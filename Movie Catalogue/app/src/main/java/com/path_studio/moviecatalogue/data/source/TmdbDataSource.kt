package com.path_studio.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.path_studio.moviecatalogue.data.DetailMovieEntity
import com.path_studio.moviecatalogue.data.DetailTvShowEntity
import com.path_studio.moviecatalogue.data.MovieEntity
import com.path_studio.moviecatalogue.data.TvShowEntity

interface TmdbDataSource {
    fun getDiscoverMovies(): LiveData<List<MovieEntity>>
    fun getDiscoverTvShow(): LiveData<List<TvShowEntity>>
    fun getDetailMovie(movieId: String): LiveData<DetailMovieEntity>
    fun getDetailTvShow(showId: String): LiveData<DetailTvShowEntity>
}