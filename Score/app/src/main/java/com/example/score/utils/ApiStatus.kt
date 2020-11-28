package com.example.score.utils

sealed class ApiStatus<out T> {

    data class Success<out T>(val data: T): ApiStatus<T>()
    class Error(val exception: Exception): ApiStatus<Nothing>()

}