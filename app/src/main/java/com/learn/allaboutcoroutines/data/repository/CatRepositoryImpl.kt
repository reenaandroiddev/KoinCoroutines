package com.learn.allaboutcoroutines.data.repository

import com.learn.allaboutcoroutines.data.CatApi
import com.learn.allaboutcoroutines.data.model.Cat
import com.learn.allaboutcoroutines.data.result.Result

class CatRepositoryImpl(private val catApi: CatApi) : CatRepository {
    override suspend fun getCatListFromRemote(): Result<List<Cat>> {
        return try {
            val result = catApi.getCatsAsync(NUMBER_OF_CATS).await()
            Result.Success(result)
        } catch (ex: Exception) {
            Result.Error(ex)
        }
    }

    override suspend fun getCatListFromLocal(): Result<List<Cat>> {
        TODO("Not yet implemented")
    }

    companion object {
        const val NUMBER_OF_CATS = 30
    }
}