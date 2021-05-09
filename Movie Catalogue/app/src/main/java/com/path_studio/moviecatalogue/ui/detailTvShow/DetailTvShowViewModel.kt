package com.path_studio.moviecatalogue.ui.detailTvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.path_studio.moviecatalogue.data.entities.DetailTvShowEntity
import com.path_studio.moviecatalogue.data.TmdbRepository

class DetailTvShowViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {
    fun getDetailTvShow(showId: String): LiveData<DetailTvShowEntity> = tmdbRepository.getDetailTvShow(showId)
    fun getLoading():LiveData<Boolean> = tmdbRepository.isLoading
}