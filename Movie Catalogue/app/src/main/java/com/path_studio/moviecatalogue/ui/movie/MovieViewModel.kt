package com.path_studio.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.path_studio.moviecatalogue.data.entities.MovieEntity
import com.path_studio.moviecatalogue.data.TmdbRepository

class MovieViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {
    fun getDiscoverMovies(): LiveData<List<MovieEntity>> = tmdbRepository.getDiscoverMovies()
    fun getLoading():LiveData<Boolean> = tmdbRepository.isLoading
}