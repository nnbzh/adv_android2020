package com.example.score.data.api

import com.example.score.data.API_KEY
import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .header("X-RapidAPI-Key", API_KEY)
            .build()
        return chain.proceed(request)
    }
}