package com.path_studio.moviecatalogue.ui.detailTvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.path_studio.moviecatalogue.data.TmdbRepository
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowWithSeason
import com.path_studio.moviecatalogue.vo.Resource

class DetailTvShowViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {

    private var tvShowData: LiveData<Resource<TvShowEntity>> = MutableLiveData()

    fun getDetailTvShow(showId: String): LiveData<Resource<TvShowEntity>>{
        tvShowData = tmdbRepository.getDetailTvShow(showId)
        return tvShowData
    }

    fun getDetailTvShowWithSeason(showId: String): LiveData<TvShowWithSeason> = tmdbRepository.getTvShowWithSeason(showId)

    fun setFavorite() {
        val tvShowResource = tvShowData.value
        if (tvShowResource != null) {
            val tvShowDetail = tvShowResource.data
            val newState = !tvShowDetail!!.favorite
            tmdbRepository.setFavoriteTvShow(tvShowDetail, newState)
        }
    }

}