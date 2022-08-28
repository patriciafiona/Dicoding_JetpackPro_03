package com.path_studio.moviecatalogue

import android.app.Application
import com.path_studio.moviecatalogue.di.appModule
import com.path_studio.moviecatalogue.di.repoModule
import com.path_studio.moviecatalogue.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application(){
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }
}