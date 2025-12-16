package com.example.mykmpapp.domain.repository

import com.example.mykmpapp.data.remote.ApiClient
import com.example.mykmpapp.data.remote.ProductFirestoreDataSource
import com.example.mykmpapp.data.model.Product

class ProductRepository {

    private val firestoreDataSource = ProductFirestoreDataSource()

    suspend fun fetchFromApiAndStore(): List<Product> {
        val products = ApiClient.fetchProducts()
        firestoreDataSource.saveProducts(products)
        return products
    }

    suspend fun getFromFirestore(): List<Product> {
        return firestoreDataSource.getProducts()
    }
}
