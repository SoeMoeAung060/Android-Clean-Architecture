package com.example.cleanarchitecture.store.presentation.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.util.EventBus
import kotlinx.coroutines.launch

fun ViewModel.sentEvent(event: Any){
    viewModelScope.launch {
        EventBus.sendEvent(event)
    }
}