package com.path_studio.moviecatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.path_studio.moviecatalogue.data.TmdbRepository
import com.path_studio.moviecatalogue.di.Injection
import com.path_studio.moviecatalogue.ui.detailMovie.DetailMovieViewModel
import com.path_studio.moviecatalogue.ui.detailTvShow.DetailTvShowViewModel
import com.path_studio.moviecatalogue.ui.mainPage.favorite.favoriteMovie.FavoriteMovieViewModel
import com.path_studio.moviecatalogue.ui.mainPage.favorite.favoriteTvShow.FavoriteTvShowViewModel
import com.path_studio.moviecatalogue.ui.mainPage.movie.MovieViewModel
import com.path_studio.moviecatalogue.ui.mainPage.tvShow.TvShowViewModel

class ViewModelFactory private constructor(private val mTmdbRepository: TmdbRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                ViewModelFactory(Injection.provideImdbRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mTmdbRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel(mTmdbRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(mTmdbRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                DetailTvShowViewModel(mTmdbRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteMovieViewModel::class.java) -> {
                FavoriteMovieViewModel(mTmdbRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteTvShowViewModel::class.java) -> {
                FavoriteTvShowViewModel(mTmdbRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}