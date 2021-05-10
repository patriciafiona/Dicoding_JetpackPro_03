package com.path_studio.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.path_studio.moviecatalogue.data.TmdbRepository
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.vo.Resource

class MovieViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {
    fun getDiscoverMovies(): LiveData<Resource<PagedList<MovieEntity>>> = tmdbRepository.getDiscoverMovies()
    fun getLoading():LiveData<Boolean> = tmdbRepository.isLoading
}