package com.path_studio.moviecatalogue.ui.detailTvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.path_studio.moviecatalogue.data.TmdbRepository

class DetailTvShowViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {
    val showId = MutableLiveData<String>()

    fun setSelectedTvShow(showId: String) {
        this.showId.value = showId
    }

//    var seasonData: LiveData<Resource<TvShowWithSeason>> = Transformations.switchMap(showId) { mShowId ->
//        tmdbRepository.getTvShowWithSeason(mShowId)
//    }

//    fun setFavorite() {
//       tmdbRepository.setFavoriteTvShow()
//    }

    fun getLoading():LiveData<Boolean> = tmdbRepository.isLoading
}