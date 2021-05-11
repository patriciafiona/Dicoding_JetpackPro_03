package com.path_studio.moviecatalogue.ui.tvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.path_studio.moviecatalogue.data.TmdbRepository
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.vo.Resource

class TvShowViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {
    fun getDiscoverTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> = tmdbRepository.getDiscoverTvShow()
}