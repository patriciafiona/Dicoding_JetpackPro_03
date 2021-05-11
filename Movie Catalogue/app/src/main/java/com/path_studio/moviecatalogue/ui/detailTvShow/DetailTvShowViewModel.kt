package com.path_studio.moviecatalogue.ui.detailTvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.path_studio.moviecatalogue.data.TmdbRepository
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowWithSeason
import com.path_studio.moviecatalogue.vo.Resource

class DetailTvShowViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {

    fun getDetailTvShow(showId: String, currentFav: Boolean): LiveData<Resource<TvShowEntity>> = tmdbRepository.getDetailTvShow(showId, currentFav)
    fun getLoading():LiveData<Boolean> = tmdbRepository.isLoading

    fun getDetailTvShowWithSeason(showId: String): LiveData<TvShowWithSeason>{
        return tmdbRepository.getTvShowWithSeason(showId)
    }


//    fun setFavorite() {
//       tmdbRepository.setFavoriteTvShow()
//    }

}