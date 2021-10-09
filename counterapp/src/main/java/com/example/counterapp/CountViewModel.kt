package com.example.counterapp

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {

    /**
     * カウント回数を保持
     */
    val count: MutableState<Int> = mutableStateOf<Int>(0)

    fun onCountUpTrapped() {
        val currentValue = count.value
        count.value = currentValue + 1
    }
}