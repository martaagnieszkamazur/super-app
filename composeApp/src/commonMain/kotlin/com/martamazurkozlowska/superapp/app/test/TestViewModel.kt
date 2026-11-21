package com.martamazurkozlowska.superapp.app.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TestViewModel : ViewModel() {

    private val clickCounter = MutableStateFlow<Int>(0)
    val clickCounterFlow = clickCounter.asStateFlow()

    private val message = MutableStateFlow<String>("")
    val messageFlow = message.asStateFlow()

    init {
        viewModelScope.launch {
            clickCounterFlow.collect {
                message.value = "Message $it"
            }
        }
    }

    fun onIncrementCounterClick() {
        clickCounter.value++
    }
    
    fun onMessageButtonClick() {
        message.value = "Message cleared"
    }
}