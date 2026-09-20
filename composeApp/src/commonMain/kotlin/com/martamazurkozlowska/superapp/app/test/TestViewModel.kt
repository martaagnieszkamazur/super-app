package com.martamazurkozlowska.superapp.app.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
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
        println("On test button click!!!!!!!!!!!!!!")
        clickCounter.value++
        println("${clickCounter.value}")

        viewModelScope.launch {
            someOperationsInBackground(index = 1)
        }

        viewModelScope.launch {
            someOperationsInBackground(index = 2)
        }

        println("Last print!!!")
    }

    private suspend fun someOperationsInBackground(
        index: Int,
    ) {
        println("Started operation in background $index")
        delay(timeMillis = 3_000)
        println("Finished operation in background $index")
    }

    fun onMessageButtonClick() {
        message.value = "Message cleared"
    }
}