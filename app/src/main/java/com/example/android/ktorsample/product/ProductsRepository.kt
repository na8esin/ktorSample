package com.example.android.ktorsample.product

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ProductsRepository(private val client: HttpClient) {
    suspend fun find(id: Int): Product {
        return client.get("https://dummyjson.com/products/$id").body()
    }
}