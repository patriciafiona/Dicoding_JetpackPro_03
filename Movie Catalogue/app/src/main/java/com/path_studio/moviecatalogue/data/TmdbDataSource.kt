package com.path_studio.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.path_studio.moviecatalogue.data.entities.SearchEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowWithSeason
import com.path_studio.moviecatalogue.vo.Resource

interface TmdbDataSource {
    fun getDiscoverMovies(): LiveData<Resource<PagedList<MovieEntity>>>
    fun getDiscoverTvShow(): LiveData<Resource<PagedList<TvShowEntity>>>
    fun getDetailMovie(movieId: String): LiveData<Resource<MovieEntity>>
    fun getDetailTvShow(showId: String): LiveData<Resource<TvShowEntity>>
    fun getTvShowWithSeason(showId: String): LiveData<TvShowWithSeason>
    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>>
    fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>>
    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean)
    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean)
    fun getSearchResult(title: String): LiveData<List<SearchEntity>>
}