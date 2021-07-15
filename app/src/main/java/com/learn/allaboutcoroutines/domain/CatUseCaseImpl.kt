package com.learn.allaboutcoroutines.domain

import com.learn.allaboutcoroutines.data.model.Cat
import com.learn.allaboutcoroutines.data.repository.CatRepository
import com.learn.allaboutcoroutines.data.result.Result

class CatUseCaseImpl(private val repository: CatRepository) : CatUseCase {
    override suspend fun getCatListFromRepository(): Result<List<Cat>> {
        return repository.getCatListFromRemote()
    }
}