package com.path_studio.moviecatalogue.navigations

import android.provider.ContactsContract
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.path_studio.moviecatalogue.data.entities.Movie
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.ui.detailMovie.DetailMovieScreen
import com.path_studio.moviecatalogue.ui.mainPage.MainScreen
import com.path_studio.moviecatalogue.ui.splash.SplashScreen

@Composable
fun NavigationBuilder() {
    val navigationController = rememberNavController()

    NavHost(
        navController = navigationController,
        startDestination = TmdbScreen.SplashScreen.route
    ) {
        composable(route = TmdbScreen.SplashScreen.route) {
            SplashScreen(navController = navigationController)
        }

        composable(route = TmdbScreen.MainScreen.route) {
            MainScreen(navController = navigationController)
        }

        composable(route = TmdbScreen.DetailMovieScreen.route) { previousBackStackEntry ->
            val data = previousBackStackEntry.arguments?.getParcelable<Movie>("movie")
            if (data != null) {
                DetailMovieScreen(navController = navigationController, data = data)
            }else{
                DetailMovieScreen(navController = navigationController, data = null)
            }
        }

    }
}