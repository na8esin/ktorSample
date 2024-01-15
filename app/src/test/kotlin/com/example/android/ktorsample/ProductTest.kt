package com.example.android.ktorsample

import kotlinx.serialization.json.Json
import org.junit.Test

class ProductTest {
    @Test
    fun test() {
        val obj = Json.decodeFromString<Product>("""
            {"id":1,"title":"Product 1"}
        """)
        println(obj)
    }
}