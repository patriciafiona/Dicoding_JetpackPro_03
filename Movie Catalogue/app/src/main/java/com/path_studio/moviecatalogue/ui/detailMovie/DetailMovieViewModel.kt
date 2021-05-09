package com.path_studio.moviecatalogue.ui.detailMovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.path_studio.moviecatalogue.data.entities.DetailMovieEntity
import com.path_studio.moviecatalogue.data.TmdbRepository

class DetailMovieViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {
    fun getDetailMovie(movieId: String): LiveData<DetailMovieEntity> = tmdbRepository.getDetailMovie(movieId)
    fun getLoading():LiveData<Boolean> = tmdbRepository.isLoading
}