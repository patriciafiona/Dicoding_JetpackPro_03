package com.path_studio.moviecatalogue.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.path_studio.moviecatalogue.helper.di.appModule
import com.path_studio.moviecatalogue.helper.di.repoModule
import com.path_studio.moviecatalogue.helper.di.viewModelModule
import com.path_studio.moviecatalogue.navigations.NavigationBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class TmdbApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlobalContext.startKoin {
                androidContext(this@TmdbApp)

                modules(appModule, repoModule, viewModelModule)
            }
            NavigationBuilder()
        }
    }
}