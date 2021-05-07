package com.path_studio.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.path_studio.moviecatalogue.data.MovieEntity
import com.path_studio.moviecatalogue.data.source.TmdbRepository

class MovieViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {
    fun getDiscoverMovies(): LiveData<List<MovieEntity>> = tmdbRepository.getDiscoverMovies()
    fun getLoading():LiveData<Boolean> = tmdbRepository.isLoading
}