package com.example.android.ktorsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.android.ktorsample.product.Product
import com.example.android.ktorsample.product.ProductsRepository
import kotlinx.coroutines.launch

class GameViewModel(
    private val repository: ProductsRepository
) : ViewModel() {
    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product>
        get() = _product

    fun init() {
//        viewModelScope.launch {
//            repository.find(1).let {
//                _product.value = it
//            }
//        }
    }

    fun updateProduct() {
        viewModelScope.launch {
            repository.find(1).let {
                _product.value = it
            }
        }
    }
}

class GameViewModelFactory(private val repository: ProductsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GameViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}