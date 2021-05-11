package com.path_studio.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.SeasonEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowWithSeason
import com.path_studio.moviecatalogue.data.source.local.room.TmdbDao

class LocalDataSource private constructor(private val mTmdbDao: TmdbDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(tmdbDao: TmdbDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(tmdbDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mTmdbDao.getDiscoverMovie()

    fun getMovieById(movieId: String): LiveData<MovieEntity> =
        mTmdbDao.getMovieById(movieId)

    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity> = mTmdbDao.getFavoriteMovie()

    fun getAllTvShow(): DataSource.Factory<Int, TvShowEntity> = mTmdbDao.getDiscoverTvShow()

    fun getTvShowById(showId: String): LiveData<TvShowEntity> =
        mTmdbDao.getTvShowById(showId)

    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShowEntity> = mTmdbDao.getFavoriteTvShow()

    fun getTvShowWithSeason(showId: String): LiveData<TvShowWithSeason> =
        mTmdbDao.getSeasonByTvShowId(showId)

    fun insertMovies(movies: ArrayList<MovieEntity>) = mTmdbDao.insertMovie(movies)

    fun insertTvShow(tvShows: ArrayList<TvShowEntity>) = mTmdbDao.insertTvShow(tvShows)

    fun insertSeason(seasons: List<SeasonEntity>) = mTmdbDao.insertSeason(seasons)

    fun setMovieFavorite(movie : MovieEntity) {
        movie.favorite = !movie.favorite
        mTmdbDao.updateMovie(movie)
    }

    fun setTvShowFavorite(tvShow : TvShowEntity) {
        tvShow.favorite = !tvShow.favorite
        mTmdbDao.updateTvShow(tvShow)
    }

    fun updateMovie(movie: MovieEntity){
        mTmdbDao.updateMovie(movie)
    }

    fun updateTvShow(tvShow: TvShowEntity){
        mTmdbDao.updateTvShow(tvShow)
    }

}