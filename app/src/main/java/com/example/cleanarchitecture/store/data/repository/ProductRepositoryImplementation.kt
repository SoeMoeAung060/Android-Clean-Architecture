package com.example.cleanarchitecture.store.data.repository

import arrow.core.Either
import com.example.cleanarchitecture.store.data.mapper.toNetworkError
import com.example.cleanarchitecture.store.data.remote.ProductApi
import com.example.cleanarchitecture.store.domain.model.Product
import com.example.cleanarchitecture.store.domain.repository.NetworkError
import com.example.cleanarchitecture.store.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImplementation @Inject constructor(
    private val productApi: ProductApi
) : ProductRepository {

    override suspend fun getProduct(): Either<NetworkError, List<Product>> {
        return Either.catch {
            productApi.getProducts()
        }.mapLeft { it.toNetworkError() }
    }


}