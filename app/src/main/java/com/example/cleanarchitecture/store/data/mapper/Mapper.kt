package com.example.cleanarchitecture.store.data.mapper

import com.example.cleanarchitecture.store.domain.repository.ApiError
import com.example.cleanarchitecture.store.domain.repository.NetworkError
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toNetworkError() : NetworkError{
    val error =  when(this){
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }

    return NetworkError(
        error = error,
        t = this
    )
}