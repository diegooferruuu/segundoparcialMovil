package com.calyrsoft.ucbp1.features.login.domain.repository

import com.calyrsoft.ucbp1.features.login.domain.model.LoginModel

interface ILoginRepository {
    fun doLogin(email: String, password: String): Result<LoginModel>
}