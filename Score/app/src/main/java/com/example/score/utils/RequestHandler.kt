package com.example.score.utils

import retrofit2.Response
import java.lang.Exception

object RequestHandler {

    fun <T: Any> handleSuccess(response: Response<T>): ApiStatus<T> {
        response.body()?.let {
            return ApiStatus.Success(it)
        } ?: return ApiStatus.Error(Exception())
    }
}