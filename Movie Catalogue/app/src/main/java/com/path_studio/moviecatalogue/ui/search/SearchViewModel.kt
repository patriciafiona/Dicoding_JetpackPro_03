package com.path_studio.moviecatalogue.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.path_studio.moviecatalogue.data.entities.SearchEntity
import com.path_studio.moviecatalogue.data.TmdbRepository

class SearchViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {
    fun getSearchResult(title: String): LiveData<List<SearchEntity>> = tmdbRepository.getSearchResult(title)
    fun getLoading(): LiveData<Boolean> = tmdbRepository.isLoading
}