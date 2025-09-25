package com.calyrsoft.ucbp1.features.github.data.repository

import com.calyrsoft.ucbp1.features.github.data.datasource.GithubRemoteDataSource
import com.calyrsoft.ucbp1.features.github.domain.model.Nickname
import com.calyrsoft.ucbp1.features.github.domain.model.UrlPath
import com.calyrsoft.ucbp1.features.github.domain.model.UserModel
import com.calyrsoft.ucbp1.features.github.domain.repository.IGithubRepository

class GithubRepository(
    val remoteDataSource: GithubRemoteDataSource
): IGithubRepository {
    override suspend fun findByNick(value: String): Result<UserModel> {
        if(value.isEmpty()) {
            return Result.failure(Exception("El campo no puede estar vacio"))
        }
        val response = remoteDataSource.getUser(value)
        response.fold(
            onSuccess = {
                it -> return Result.success(UserModel(
                    nickname = Nickname(it.login),
                    pathUrl = UrlPath(it.url)
                ))
            },
            onFailure = {
                return Result.failure(it)
            }
        )

    }
}