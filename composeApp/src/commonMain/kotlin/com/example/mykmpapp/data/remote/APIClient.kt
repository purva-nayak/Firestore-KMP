package com.example.mykmpapp.data.remote

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import com.example.mykmpapp.data.model.Product
import com.example.mykmpapp.data.model.ProductsResponse

object ApiClient {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun fetchProducts(): List<Product> {
        val response: ProductsResponse =
            client.get("https://dummyjson.com/products?limit=10").body()
        return response.products
    }
}
