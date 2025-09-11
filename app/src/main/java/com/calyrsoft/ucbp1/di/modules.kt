package com.calyrsoft.ucbp1.di

import com.calyrsoft.ucbp1.features.github.data.api.GithubSerivce
import com.calyrsoft.ucbp1.features.github.data.datasource.GithubRemoteDataSource
import com.calyrsoft.ucbp1.features.github.data.repository.GithubRepository
import com.calyrsoft.ucbp1.features.github.domain.repository.IGithubRepository
import com.calyrsoft.ucbp1.features.github.domain.usecase.FindByNickNameUseCase
import com.calyrsoft.ucbp1.features.github.presentation.GithubViewModel
import com.calyrsoft.ucbp1.features.login.data.repository.LoginRepository
import com.calyrsoft.ucbp1.features.login.domain.repository.ILoginRepository
import com.calyrsoft.ucbp1.features.login.domain.usecase.LoginUsecase
import com.calyrsoft.ucbp1.features.login.presentation.LoginViewModel
import com.calyrsoft.ucbp1.features.movies.data.api.MoviesService
import com.calyrsoft.ucbp1.features.movies.data.datasource.ThemoviedbDataSource
import com.calyrsoft.ucbp1.features.movies.data.repository.MoviesRepository
import com.calyrsoft.ucbp1.features.movies.domain.repository.IMoviesRepository
import com.calyrsoft.ucbp1.features.movies.domain.usecase.FetchMoviesUseCase
import com.calyrsoft.ucbp1.features.movies.presentation.MoviesViewModel
import com.google.gson.Gson
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {
    single {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<MoviesService>{
        get<Retrofit>().create(MoviesService::class.java)
    }
    single{ ThemoviedbDataSource(get()) }
    single<IMoviesRepository>{ MoviesRepository(get()) }
    factory{ FetchMoviesUseCase(get()) }
    viewModel { MoviesViewModel(get()) }

    single<GithubSerivce> {
        get<Retrofit>().create(GithubSerivce::class.java)
    }
    single{ GithubRemoteDataSource(get()) }
    single<IGithubRepository>{ GithubRepository(get()) }
    factory { FindByNickNameUseCase(get()) }
    viewModel { GithubViewModel(get()) }

    single<ILoginRepository>{LoginRepository()}
    factory { LoginUsecase(get()) }
    viewModel { LoginViewModel(get()) }

}