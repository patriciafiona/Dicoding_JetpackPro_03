package com.path_studio.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.SeasonEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity

@Dao
interface TmdbDao {

    //Movie
    @Query("SELECT * FROM movie_entities")
    fun getDiscoverMovie(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movie_entities where favorite = 1")
    fun getFavoriteMovie(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movie_entities WHERE movieId = :movieId")
    fun getMovieById(movieId: String): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    //Tv SHow
    @Query("SELECT * FROM tv_show_entities")
    fun getDiscoverTvShow(): LiveData<List<TvShowEntity>>

    @Query("SELECT * FROM tv_show_entities where favorite = 1")
    fun getFavoriteTvShow(): LiveData<List<TvShowEntity>>

    @Query("SELECT * FROM tv_show_entities WHERE tvShowId = :tvShowId")
    fun getTvShowById(tvShowId: String): LiveData<TvShowEntity>

    @Query("SELECT * FROM season_entities WHERE tvShowId = :tvShowId")
    fun getSeasonByTvShowId(tvShowId: String): LiveData<List<SeasonEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShow: List<TvShowEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSeason(season: List<SeasonEntity>)

    @Update
    fun updateTvShow(tvShow: TvShowEntity)
}