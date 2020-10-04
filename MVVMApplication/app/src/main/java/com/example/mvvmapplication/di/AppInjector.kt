package com.example.mvvmapplication.di

import com.example.mvvmapplication.data.api.ApiClient
import com.example.mvvmapplication.ui.detail.MovieDetailsViewModel
import com.example.mvvmapplication.ui.movies.MoviesListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single { ApiClient.getApi(get()) }
    single { ApiClient.getOkHttpClient(get()) }
    single { ApiClient.getLoggingInterceptor() }
}

val viewModelModule = module {
    viewModel { MoviesListViewModel(get()) }
    viewModel { MovieDetailsViewModel(get()) }
}