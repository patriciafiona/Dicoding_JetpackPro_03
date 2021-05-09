package com.path_studio.moviecatalogue.data

import androidx.lifecycle.LiveData
import com.path_studio.moviecatalogue.data.entities.*

interface TmdbDataSource {
    fun getDiscoverMovies(): LiveData<List<MovieEntity>>
    fun getDiscoverTvShow(): LiveData<List<TvShowEntity>>
    fun getDetailMovie(movieId: String): LiveData<DetailMovieEntity>
    fun getDetailTvShow(showId: String): LiveData<DetailTvShowEntity>
    fun getSearchResult(title: String): LiveData<List<SearchEntity>>
}