package com.abeltarazona.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

/**
 * Created by AbelTarazona on 5/05/2021
 */
abstract class BaseViewModel : ViewModel() {

    private val job: Job = Job()

    abstract val coroutineExceptionHandler: CoroutineExceptionHandler

    protected fun launchCoroutineIO(block: suspend CoroutineScope.() -> Unit): Job {
        return viewModelScope.launch(Dispatchers.IO + job + coroutineExceptionHandler) {
            block()
        }
    }

    protected fun launchCoroutineMain(block: suspend CoroutineScope.() -> Unit): Job {
        return viewModelScope.launch(Dispatchers.Main + job + coroutineExceptionHandler) {
            block()
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}