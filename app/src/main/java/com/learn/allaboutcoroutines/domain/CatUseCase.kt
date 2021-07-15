package com.learn.allaboutcoroutines.domain

import com.learn.allaboutcoroutines.data.model.Cat
import com.learn.allaboutcoroutines.data.result.Result

interface CatUseCase {
    suspend fun getCatListFromRepository(): Result<List<Cat>>
}