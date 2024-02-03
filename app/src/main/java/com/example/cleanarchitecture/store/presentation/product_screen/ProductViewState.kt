package com.example.cleanarchitecture.store.presentation.product_screen

import com.example.cleanarchitecture.store.domain.model.Product

data class ProductViewState(
    val isLoading: Boolean = false,
    val product: List<Product> = emptyList(),
    val error: String? = null
)
