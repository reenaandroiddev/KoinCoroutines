package com.learn.allaboutcoroutines.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.allaboutcoroutines.data.model.Cat
import com.learn.allaboutcoroutines.data.result.Result
import com.learn.allaboutcoroutines.domain.CatUseCase
import com.learn.allaboutcoroutines.ui.event.SingleLiveEvent
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CatViewModel(private val catUseCase: CatUseCase) : ViewModel(), CoroutineScope {
    // Coroutine's background job
    private val job = Job()

    // Define default thread for Coroutine as Main and add job
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    val catList = MutableLiveData<List<Cat>>()
    val error = SingleLiveEvent<String>()

    fun loadCats() {
        launch {
            // Switching from MAIN to IO thread for API operation
            // Update our data list with the new one from API
            val result = withContext(Dispatchers.IO) {
                catUseCase.getCatListFromRepository()
            }
            when (result) {
                is Result.Success -> catList.value = result.data
                is Result.Error -> error.value = result.exception.message
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}