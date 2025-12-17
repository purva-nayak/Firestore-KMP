package com.example.mykmpapp.data.remote

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore
import com.example.mykmpapp.data.model.Product

class ProductFirestoreDataSource {

    private val firestore = Firebase.firestore
    private val productsCollection = firestore.collection("products")

    suspend fun saveProducts(products: List<Product>) {
        products.forEach { product ->
            productsCollection
                .document(product.id.toString())
                .set(product)
        }
    }

    suspend fun getProducts(): List<Product> {
        return productsCollection
            .get()
            .documents
            .mapNotNull { it.data<Product>() }
    }

    suspend fun deleteProduct(productId: String) {
        productsCollection.document(productId).delete()
    }

    suspend fun restoreProduct(product: Product) {
        productsCollection.document(product.id.toString()).set(product)
    }

}
