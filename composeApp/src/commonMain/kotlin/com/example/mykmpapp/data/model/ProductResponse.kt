package com.example.mykmpapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ProductsResponse(
    val products: List<Product>
)
