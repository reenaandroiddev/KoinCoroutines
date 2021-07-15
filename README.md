# KoinCoroutines

In this project you will get to know about 
1. How to make api call using Kotlin Corouines 
2. How to do dependencey Injection using koin


## Architecture
Clean Architecture and MVVM


## Dependencies Used
  1. Glide for loading and caching Images
  
    implementation "com.github.bumptech.glide:glide:$glide_version"
    kapt "com.github.bumptech.glide:compiler:$glide_version"

  2. Retrofit as our REST service
  
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:adapter-rxjava2:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"

   3. Coroutines for asynchronous calls (and Deferred’s adapter)

    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_verison"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_verison"

   4. Coroutines - Deferred adapter
   
    implementation 'com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2'

   5. Koin for the dependencies injections
   
    implementation 'org.koin:koin-android-viewmodel:2.0.0-rc-2'
    
 ## Overview about Classes and Modules
   1. Modules contains the classes that are going to be assembled inside appModule scope (in this case our Retrofit service and CatRepository).
   2. To build Retrofit service, we will use createWebService() as singleton
   3. Our CatRepository is built here using Koin’s get() to satisfy constructor’s parameters. Whenever we’ll need it, Koin will provide it for us when we’ll use “by inject”.
   4. We now need to add this appModules inside our Application to have access to it inside our app.
  
 ## General Terms
   1. CoroutineScope has to be implemented in classes that are going to switch threads. With it comes CoroutineContext which we have to override.
   2. MutableLiveData type is, as the name says, a mutable LiveData (we can set values).
   3. ingleLiveEvent type is, in short, a LiveData that triggers only ones.


