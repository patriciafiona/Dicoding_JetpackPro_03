package com.path_studio.moviecatalogue.ui.tvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.path_studio.moviecatalogue.data.entities.TvShowEntity
import com.path_studio.moviecatalogue.data.TmdbRepository

class TvShowViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {
    fun getDiscoverTvShow(): LiveData<List<TvShowEntity>> = tmdbRepository.getDiscoverTvShow()
    fun getLoading():LiveData<Boolean> = tmdbRepository.isLoading
}