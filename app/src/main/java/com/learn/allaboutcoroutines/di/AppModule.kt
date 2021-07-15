package com.learn.allaboutcoroutines.di

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.learn.allaboutcoroutines.data.CatApi
import com.learn.allaboutcoroutines.data.repository.CatRepository
import com.learn.allaboutcoroutines.data.repository.CatRepositoryImpl
import com.learn.allaboutcoroutines.domain.CatUseCase
import com.learn.allaboutcoroutines.domain.CatUseCaseImpl
import com.learn.allaboutcoroutines.ui.CatViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val CAT_API_BASE_URL = "https://api.thecatapi.com/v1/"

val appModules = module {

    // The Retrofit service using our custom HTTP client instance as a singleton
    single {
        createWebservice<CatApi>(
            factory = RxJava2CallAdapterFactory.create(),
            baseUrl = CAT_API_BASE_URL
        )
    }

    factory<CatRepository> { CatRepositoryImpl(catApi = get()) }
    factory<CatUseCase> { CatUseCaseImpl(repository = get()) }

    viewModel { CatViewModel(catUseCase = get()) }

}

inline fun <reified T> createWebservice(
    factory: CallAdapter.Factory,
    baseUrl: String
): T {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addCallAdapterFactory(factory)
        .build().create(T::class.java)
}