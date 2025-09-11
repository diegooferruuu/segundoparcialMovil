package com.calyrsoft.ucbp1.features.login.data.repository

import com.calyrsoft.ucbp1.features.login.domain.model.LoginModel
import com.calyrsoft.ucbp1.features.login.domain.repository.ILoginRepository

class LoginRepository : ILoginRepository {
    override fun doLogin(email: String, password: String): Result<LoginModel> {
        if (email.isEmpty() || password.isEmpty())
        {
            return Result.failure(Exception("El campo no puede estar vacio"))
        }
        return Result.success(
            LoginModel(
                email,
                password
            )
        )
    }
}