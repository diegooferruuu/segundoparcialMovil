package com.calyrsoft.ucbp1.features.login.domain.usecase

import com.calyrsoft.ucbp1.features.login.domain.model.LoginModel
import com.calyrsoft.ucbp1.features.login.domain.repository.ILoginRepository
import kotlinx.coroutines.delay

class LoginUsecase(val repository: ILoginRepository) {
    suspend fun invoke(email: String, password: String): Result<LoginModel>
    {
        delay(500)
        return repository.doLogin(email, password)
    }

}