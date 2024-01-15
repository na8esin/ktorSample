package com.example.android.ktorsample.product

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import org.junit.Test

class ProductTest {
    /**
     * https://github.com/Kotlin/kotlinx.serialization/blob/master/guide/example/example-readme-01.kt
     * 動かないけど保留
     */
    @Test
    fun serialize() {
        // Deserializing back into objects
        val obj = Json.decodeFromString<Product>("""
            {"id":1,"title":"Product 1"}
        """)
        println(obj)
    }
}