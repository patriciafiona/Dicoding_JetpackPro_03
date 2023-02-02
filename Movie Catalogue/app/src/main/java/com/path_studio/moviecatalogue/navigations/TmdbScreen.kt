package com.path_studio.moviecatalogue.navigations

sealed class TmdbScreen(val route: String) {
    object SplashScreen: TmdbScreen("splash_screen")
    object MainScreen: TmdbScreen("main_screen")
    object DetailMovieScreen: TmdbScreen("detail_movie_screen")
    object DetailTvShowScreen: TmdbScreen("detail_tv_show_screen")
    object SearchScreen: TmdbScreen("search_screen")
}