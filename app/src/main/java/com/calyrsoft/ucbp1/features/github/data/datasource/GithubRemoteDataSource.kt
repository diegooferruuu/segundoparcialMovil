package com.calyrsoft.ucbp1.features.github.data.datasource

import com.calyrsoft.ucbp1.features.github.data.api.GithubSerivce
import com.calyrsoft.ucbp1.features.github.data.api.dto.GithubDto

class GithubRemoteDataSource(
    val githubSerivce: GithubSerivce
) {
    suspend fun getUser(nick: String): Result<GithubDto> {
        val response = githubSerivce.getInfoAvatar(nick)
        if (response.isSuccessful){
            return Result.success(response.body()!!)
        }
        else
        {
            return Result.failure(Exception("Error al obtener el usuario"))
        }
    }
}