package com.calyrsoft.ucbp1.features.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.calyrsoft.ucbp1.features.github.presentation.GithubViewModel.GithubStateUI
import com.calyrsoft.ucbp1.features.login.domain.model.LoginModel
import com.calyrsoft.ucbp1.features.login.domain.usecase.LoginUsecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(val usecase: LoginUsecase): ViewModel(){
    sealed class LoginStateUI {
        object Init: LoginStateUI()
        object Loading: LoginStateUI()
        class Error(val errorMessage: String): LoginStateUI()
        class Success(val loginModel: LoginModel): LoginStateUI()
    }

    private val _state = MutableStateFlow<LoginStateUI>(LoginStateUI.Init)

    val state : StateFlow<LoginStateUI> = _state.asStateFlow()

    fun fetchLogin(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = LoginStateUI.Loading
            val result = usecase.invoke(email, password)
            result.fold(
                onSuccess = { user ->
                    _state.value = LoginStateUI.Success(user)
                },
                onFailure = { error ->
                    _state.value = LoginStateUI.Error(error.message ?: "Error al iniciar sesion")
                }
            )
        }
    }
}