package com.example.score.core

import android.app.Application
import com.example.score.di.networkModule
import com.example.score.di.repositoryModule
import com.example.score.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ScoreApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ScoreApplication)
            modules(networkModule, repositoryModule, viewModelModule)
        }
    }
}