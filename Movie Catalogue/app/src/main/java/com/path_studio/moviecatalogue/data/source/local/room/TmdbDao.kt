package com.path_studio.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.SeasonEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowWithSeason

@Dao
interface TmdbDao {

    //Movie
    @Query("SELECT * FROM movie_entities ORDER BY movieId ASC")
    fun getDiscoverMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movie_entities where favorite = 1")
    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movie_entities WHERE movieId = :movieId")
    fun getMovieById(movieId: String): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    //Tv Show
    @Query("SELECT * FROM tv_show_entities ORDER BY tvShowId ASC")
    fun getDiscoverTvShow(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tv_show_entities where favorite = 1")
    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tv_show_entities WHERE tvShowId = :tvShowId")
    fun getTvShowById(tvShowId: String): LiveData<TvShowEntity>

    @Query("SELECT * FROM season_entities INNER JOIN tv_show_entities ON tv_show_entities.tvShowId = season_entities.tvShowId WHERE season_entities.tvShowId = :tvShowId")
    fun getSeasonByTvShowId(tvShowId: String): LiveData<TvShowWithSeason>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShow: List<TvShowEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSeason(season: List<SeasonEntity>)

    @Update
    fun updateTvShow(tvShow: TvShowEntity)
}