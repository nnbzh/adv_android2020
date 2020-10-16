package com.example.score.data.api

import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .header("X-RapidAPI-Key","08f03849c4b1007352b9200f5ba9afa7")
            .build()
        return chain.proceed(request)
    }
}