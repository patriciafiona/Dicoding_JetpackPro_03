package com.path_studio.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.SeasonEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.data.source.local.room.TmdbDao

class LocalDataSource private constructor(private val mTmdbDao: TmdbDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(tmdbDao: TmdbDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(tmdbDao)
    }

    fun getAllMovies(): LiveData<List<MovieEntity>> = mTmdbDao.getDiscoverMovie()

    fun getMovieById(movieId: String): LiveData<MovieEntity> =
        mTmdbDao.getMovieById(movieId)

    fun getFavoriteMovie(): LiveData<List<MovieEntity>> = mTmdbDao.getFavoriteMovie()

    fun getAllTvShow(): LiveData<List<TvShowEntity>> = mTmdbDao.getDiscoverTvShow()

    fun getTvShowById(showId: String): LiveData<TvShowEntity> =
        mTmdbDao.getTvShowById(showId)

    fun getFavoriteTvShow(): LiveData<List<TvShowEntity>> = mTmdbDao.getFavoriteTvShow()

    fun getTvShowWithSeason(showId: String): LiveData<List<SeasonEntity>> =
        mTmdbDao.getSeasonByTvShowId(showId)

    fun insertMovies(movies: List<MovieEntity>) = mTmdbDao.insertMovie(movies)

    fun insertTvShow(tvShows: List<TvShowEntity>) = mTmdbDao.insertTvShow(tvShows)

    fun insertSeason(seasons: List<SeasonEntity>) = mTmdbDao.insertSeason(seasons)

    fun setMovieFavorite(movie: MovieEntity, newState: Boolean) {
        movie.favorite = newState
        mTmdbDao.updateMovie(movie)
    }

    fun setTvShowFavorite(show: TvShowEntity, newState: Boolean) {
        show.favorite = newState
        mTmdbDao.updateTvShow(show)
    }

}