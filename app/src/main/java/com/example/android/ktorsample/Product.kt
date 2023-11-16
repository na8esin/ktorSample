package com.example.android.ktorsample

import kotlinx.serialization.Serializable

@Serializable
data class Product(val id: Int, val title: String)
