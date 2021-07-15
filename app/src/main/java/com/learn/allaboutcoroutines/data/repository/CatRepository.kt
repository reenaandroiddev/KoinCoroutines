package com.learn.allaboutcoroutines.data.repository

import com.learn.allaboutcoroutines.data.model.Cat
import com.learn.allaboutcoroutines.data.result.Result

interface CatRepository {
    suspend fun getCatListFromRemote(): Result<List<Cat>>
    suspend fun getCatListFromLocal(): Result<List<Cat>>

}