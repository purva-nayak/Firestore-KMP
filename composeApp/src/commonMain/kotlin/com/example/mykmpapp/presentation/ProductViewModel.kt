package com.example.mykmpapp.presentation

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import com.example.mykmpapp.domain.repository.ProductRepository
import com.example.mykmpapp.data.model.Product

class ProductViewModel {

    private val repository = ProductRepository()

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    init {
        loadProducts()
    }

    private fun loadProducts() {
        CoroutineScope(Dispatchers.Default).launch {

            // 1️⃣ Fetch from API and store in Firestore
            repository.fetchFromApiAndStore()

            // 2️⃣ Read from Firestore (single source of truth)
            _products.value = repository.getFromFirestore()
        }
    }
}
