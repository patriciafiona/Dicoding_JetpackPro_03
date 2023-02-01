package com.path_studio.moviecatalogue.ui.mainPage.favorite.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.path_studio.moviecatalogue.data.TmdbRepository
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity

class FavoriteTvShowViewModel (private val tmdbRepository: TmdbRepository): ViewModel() {
    fun getTvShowFav(): LiveData<PagedList<TvShowEntity>> {
        return tmdbRepository.getFavoriteTvShow()
    }
}