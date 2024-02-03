package com.example.cleanarchitecture.store.domain.repository

import arrow.core.Either
import com.example.cleanarchitecture.store.domain.model.Product

/**
 *  Domain Layer:
 * Represents the business logic and contains entities, use cases, and business rules.
 * It is independent of the UI and external frameworks. That's why we use interface.
 * */

interface ProductRepository {

    //Either< , > --> if getProduct found error return Left part of the generic which is NetworkError
    //else success return right part of the list product
    suspend fun getProduct(): Either<NetworkError, List<Product>>
}