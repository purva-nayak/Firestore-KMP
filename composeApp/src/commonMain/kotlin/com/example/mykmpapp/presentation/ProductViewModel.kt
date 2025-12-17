package com.example.mykmpapp.presentation

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import com.example.mykmpapp.domain.repository.ProductRepository
import com.example.mykmpapp.data.model.Product

class ProductViewModel {

    private val repository = ProductRepository()

    private val scope = CoroutineScope(Dispatchers.Main)

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    private var lastDeleted: Product? = null

    init {
        loadProducts()
    }

    private fun loadProducts() {
        CoroutineScope(Dispatchers.Default).launch {
            repository.fetchFromApiAndStore()
            _products.value = repository.getFromFirestore()
        }
    }

    fun deleteProduct(product: Product) {
        lastDeleted = product
        _products.value = _products.value.filterNot { it.id == product.id }

        scope.launch {
            repository.deleteProduct(product)
        }
    }

    fun undoDelete() {
        lastDeleted?.let { product ->
            scope.launch {
                repository.restoreProduct(product)
                _products.value = repository.getFromFirestore()
            }
        }
        lastDeleted = null
    }
}
