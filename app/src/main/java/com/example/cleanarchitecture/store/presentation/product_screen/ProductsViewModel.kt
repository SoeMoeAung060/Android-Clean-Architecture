package com.example.cleanarchitecture.store.presentation.product_screen

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.store.domain.repository.ProductRepository
import com.example.cleanarchitecture.store.presentation.util.sentEvent
import com.example.cleanarchitecture.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ProductViewState())
    val state = _state.asStateFlow() //This is done to provide external access to the state in a read-only manner.

    init {
        getProduct()
    }

    private fun getProduct(){
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }

            productRepository.getProduct()
                .onRight { product ->
                    _state.update {
                        it.copy(product = product)
                    }
                }.onLeft {error ->
                    _state.update {
                        it.copy( error = error.error.message)
                    }
                    sentEvent(Event.Toast(error.error.message))
                }

            _state.update {
                it.copy(isLoading = false)
            }
        }
    }
}