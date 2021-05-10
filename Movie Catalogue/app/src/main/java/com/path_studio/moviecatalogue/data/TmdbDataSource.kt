package com.path_studio.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.vo.Resource

interface TmdbDataSource {
    fun getDiscoverMovies(): LiveData<Resource<PagedList<MovieEntity>>>
    fun getDiscoverTvShow(): LiveData<Resource<PagedList<TvShowEntity>>>
    fun getDetailMovie(movieId: String): LiveData<MovieEntity>
    fun getDetailTvShow(showId: String): LiveData<TvShowEntity>
    //fun getTvShowWithSeason(showId: String): LiveData<Resource<TvShowWithSeason>>
    //fun getSearchResult(title: String): LiveData<Resource<List<SearchEntity>>>
    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>>
    fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>>
    fun setFavoriteMovie(movie: MovieEntity)
    fun setFavoriteTvShow(tvShow: TvShowEntity)
}