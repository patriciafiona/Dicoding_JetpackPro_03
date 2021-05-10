package com.path_studio.moviecatalogue.ui.detailMovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.path_studio.moviecatalogue.data.TmdbRepository
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity

class DetailMovieViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {
    fun getDetailMovie(movieId: String): LiveData<MovieEntity> = tmdbRepository.getDetailMovie(movieId)
    fun getLoading():LiveData<Boolean> = tmdbRepository.isLoading
}