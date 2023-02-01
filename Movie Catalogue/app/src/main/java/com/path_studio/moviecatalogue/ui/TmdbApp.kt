package com.path_studio.moviecatalogue.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.path_studio.moviecatalogue.helper.di.appModule
import com.path_studio.moviecatalogue.helper.di.repoModule
import com.path_studio.moviecatalogue.helper.di.viewModelModule
import com.path_studio.moviecatalogue.navigations.NavigationBuilder
import com.path_studio.moviecatalogue.ui.ui.theme.MovieCatalogueTheme
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