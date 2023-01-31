package com.path_studio.moviecatalogue.navigations

sealed class TmdbScreen(val route: String) {
    object SplashScreen: TmdbScreen("splash_screen")
    object MainScreen: TmdbScreen("main_screen")
}