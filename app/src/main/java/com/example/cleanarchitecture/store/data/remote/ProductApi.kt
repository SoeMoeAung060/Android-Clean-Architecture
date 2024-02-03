package com.example.cleanarchitecture.store.data.remote

import com.example.cleanarchitecture.store.domain.model.Product
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun getProducts() : List<Product>
}