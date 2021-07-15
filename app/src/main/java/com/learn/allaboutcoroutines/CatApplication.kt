package com.learn.allaboutcoroutines

import android.app.Application
import com.learn.allaboutcoroutines.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CatApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CatApplication)
            modules(appModules)
        }
    }
}