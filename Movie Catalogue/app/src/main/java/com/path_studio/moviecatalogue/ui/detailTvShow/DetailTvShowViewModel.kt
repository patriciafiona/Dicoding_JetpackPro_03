package com.path_studio.moviecatalogue.ui.detailTvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.path_studio.moviecatalogue.data.TmdbRepository
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity

class DetailTvShowViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {

    fun getDetailTvShow(showId: String): LiveData<TvShowEntity> = tmdbRepository.getDetailTvShow(showId)
    fun getLoading():LiveData<Boolean> = tmdbRepository.isLoading

    /*val showId = MutableLiveData<String>()

    fun setSelectedTvShow(showId: String) {
        this.showId.value = showId
    }*/

//    var seasonData: LiveData<Resource<TvShowWithSeason>> = Transformations.switchMap(showId) { mShowId ->
//        tmdbRepository.getTvShowWithSeason(mShowId)
//    }

//    fun setFavorite() {
//       tmdbRepository.setFavoriteTvShow()
//    }

}