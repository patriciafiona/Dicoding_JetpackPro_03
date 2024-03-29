package com.path_studio.moviecatalogue.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.path_studio.moviecatalogue.ui.detailMovie.DetailMovieScreen
import com.path_studio.moviecatalogue.ui.detailTvShow.DetailTvShowScreen
import com.path_studio.moviecatalogue.ui.mainPage.MainScreen
import com.path_studio.moviecatalogue.ui.search.SearchScreen
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
            val data = previousBackStackEntry.arguments?.getLong("movieId")
            if (data != null) {
                DetailMovieScreen(navController = navigationController, movieId = data)
            }else{
                DetailMovieScreen(navController = navigationController, movieId = null)
            }
        }

        composable(route = TmdbScreen.DetailTvShowScreen.route) { previousBackStackEntry ->
            val data = previousBackStackEntry.arguments?.getLong("tvShowId")
            if (data != null) {
                DetailTvShowScreen(navController = navigationController, tvShowId = data)
            }else{
                DetailTvShowScreen(navController = navigationController, tvShowId = null)
            }
        }

        composable(route = TmdbScreen.SearchScreen.route) {
            SearchScreen(navController = navigationController)
        }

    }
}