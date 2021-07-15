package com.learn.allaboutcoroutines.data

import com.learn.allaboutcoroutines.data.model.Cat
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {
    @GET("images/search")
    fun getCatsAsync(@Query("limit") limit: Int)
            : Deferred<List<Cat>>
}