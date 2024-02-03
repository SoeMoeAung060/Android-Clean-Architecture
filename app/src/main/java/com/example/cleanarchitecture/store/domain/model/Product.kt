package com.example.cleanarchitecture.store.domain.model

import android.icu.text.CaseMap.Title

// Create Model in Domain

data class Product(
    val id : Int,
    val title: String,
    val price: Double,
    val description : String,
    val category : String,
    val image : String,
    val rating : Rating
)

data class Rating(
    val rate : Double,
    val count : Int
)
