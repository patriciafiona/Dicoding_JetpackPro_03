package com.path_studio.moviecatalogue.ui.detailMovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.path_studio.moviecatalogue.data.TmdbRepository
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.vo.Resource

class DetailMovieViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {

    private var movieData: LiveData<Resource<MovieEntity>> = MutableLiveData()

    fun getDetailMovie(movieId: String): LiveData<Resource<MovieEntity>>{
        movieData = tmdbRepository.getDetailMovie(movieId)
        return movieData
    }

    fun setFavorite() {
        val movieResource = movieData.value
        if (movieResource != null) {
            val movieDetail = movieResource.data
            val newState = !movieDetail!!.favorite
            tmdbRepository.setFavoriteMovie(movieDetail, newState)
        }
    }
}