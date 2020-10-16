package com.example.score.di

import com.example.score.data.api.ApiClient
import org.koin.dsl.module

val networkModule = module {
    single { ApiClient.getLoggingInterceptor() }
    single { ApiClient.getOkHttpClient(get()) }
    single { ApiClient.getApi(get()) }
}