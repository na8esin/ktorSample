package com.example.android.ktorsample.product

import kotlinx.serialization.Serializable

@Serializable
data class Product(val id: Int, val title: String)
