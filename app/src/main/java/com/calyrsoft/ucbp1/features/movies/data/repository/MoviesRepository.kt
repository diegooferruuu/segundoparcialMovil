package com.calyrsoft.ucbp1.features.movies.data.repository


import com.calyrsoft.ucbp1.features.movies.data.datasource.ThemoviedbDataSource
import com.calyrsoft.ucbp1.features.movies.domain.model.MovieModel
import com.calyrsoft.ucbp1.features.movies.domain.repository.IMoviesRepository

class MoviesRepository (
    val remoteDataSource: ThemoviedbDataSource
): IMoviesRepository {
    override suspend fun fetchMovies(): Result<Array<MovieModel>> {
        val response = remoteDataSource.getMovies()
        response.fold(
            onSuccess = {
                movieDtoArray ->
                val movieModelArray = movieDtoArray.map {
                    MovieModel(it.title, it.pathUrl)

                }.toTypedArray()
                return Result.success(movieModelArray)
            },
            onFailure = {
                exception ->
                return Result.failure(exception)
            }
        )
    }
}