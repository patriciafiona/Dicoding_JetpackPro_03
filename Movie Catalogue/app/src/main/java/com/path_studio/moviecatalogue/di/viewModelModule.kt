package com.path_studio.moviecatalogue.di

import com.path_studio.moviecatalogue.ui.detailMovie.DetailMovieViewModel
import com.path_studio.moviecatalogue.ui.detailTvShow.DetailTvShowViewModel
import com.path_studio.moviecatalogue.ui.mainPage.favorite.favoriteMovie.FavoriteMovieViewModel
import com.path_studio.moviecatalogue.ui.mainPage.favorite.favoriteTvShow.FavoriteTvShowViewModel
import com.path_studio.moviecatalogue.ui.mainPage.movie.MovieViewModel
import com.path_studio.moviecatalogue.ui.mainPage.tvShow.TvShowViewModel
import com.path_studio.moviecatalogue.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
    viewModel{ TvShowViewModel(get()) }
    viewModel { DetailTvShowViewModel(get()) }
    viewModel { FavoriteMovieViewModel(get()) }
    viewModel { FavoriteTvShowViewModel(get()) }
    viewModel { SearchViewModel(get()) }
}
