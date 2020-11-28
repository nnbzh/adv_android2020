package com.example.score.di

import com.example.score.data.api.ApiClient
import com.example.score.data.api.ApiService
import com.example.score.repository.TeamsRepository
import com.example.score.repository.TeamsRepositoryImpl
import com.example.score.ui.TeamsListViewModel
import org.koin.dsl.module

val networkModule = module {
    single { ApiClient.getLoggingInterceptor() }
    single { ApiClient.getOkHttpClient(get()) }
    single { ApiClient.getApi(get()) }
}

val repositoryModule = module {

    fun getTeamRepo(apiService: ApiService): TeamsRepository {
        return TeamsRepositoryImpl(apiService)
    }

    single { getTeamRepo(get()) }
}

val viewModelModule = module {
    single { TeamsListViewModel(get()) }
}