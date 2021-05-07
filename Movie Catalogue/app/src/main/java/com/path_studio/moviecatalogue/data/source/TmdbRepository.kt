package com.path_studio.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.path_studio.moviecatalogue.data.*
import com.path_studio.moviecatalogue.data.source.remote.RemoteDataSource
import com.path_studio.moviecatalogue.data.source.remote.response.DetailMovieResponse
import com.path_studio.moviecatalogue.data.source.remote.response.DetailTvShowResponse
import com.path_studio.moviecatalogue.data.source.remote.response.ResultsItemMovie
import com.path_studio.moviecatalogue.data.source.remote.response.ResultsItemTvShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TmdbRepository private constructor(private val remoteDataSource: RemoteDataSource): TmdbDataSource {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    companion object{
        @Volatile
        private var instance: TmdbRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): TmdbRepository =
            instance ?: synchronized(this){
                instance ?: TmdbRepository(remoteDataSource)
            }
    }

    override fun getDiscoverMovies(): LiveData<List<MovieEntity>> {
        _isLoading.value = true
        val listOfMovie = MutableLiveData<List<MovieEntity>>()
        CoroutineScope(IO).launch{
            remoteDataSource.getDiscoverMovie(object : RemoteDataSource.CallbackLoadDiscoverMovie{
                override fun onMoviesRecieved(movieResponse: List<ResultsItemMovie>) {
                    val movies = ArrayList<MovieEntity>()
                    for(response in movieResponse){
                        val movie = MovieEntity(
                                response.overview,
                                response.originalTitle,
                                response.title,
                                response.posterPath,
                                response.backdropPath,
                                response.releaseDate,
                                response.voteAverage,
                                response.id
                        )
                        movies.add(movie)
                    }
                    _isLoading.postValue(false)
                    listOfMovie.postValue(movies)
                }
            })
        }
        return listOfMovie
    }

    override fun getDiscoverTvShow(): LiveData<List<TvShowEntity>> {
        _isLoading.value = true
        val listOfShow = MutableLiveData<List<TvShowEntity>>()
        CoroutineScope(IO).launch{
            remoteDataSource.getDiscoverTvShow(object : RemoteDataSource.CallbackLoadDiscoverTvShow{
                override fun onTvShowRecieved(showResponse: List<ResultsItemTvShow>) {
                    val shows = ArrayList<TvShowEntity>()
                    for(response in showResponse){
                        val show = TvShowEntity(
                            response.overview,
                            response.originalName,
                            response.name,
                            response.posterPath,
                            response.backdropPath,
                            response.firstAirDate,
                            response.voteAverage,
                            response.id
                        )
                        shows.add(show)
                    }
                    _isLoading.postValue(false)
                    listOfShow.postValue(shows)
                }
            })
        }
        return listOfShow
    }

    override fun getDetailMovie(movieId: String): LiveData<DetailMovieEntity> {
        _isLoading.value = true
        val movieResult = MutableLiveData<DetailMovieEntity>()
        CoroutineScope(IO).launch{
            remoteDataSource.getMovie(movieId, object : RemoteDataSource.CallbackLoadDetailMovie{
                override fun onMovieDetailsRecieved(showResponse: DetailMovieResponse) {
                    val listOfGenre = ArrayList<String>()

                    for (genre in (showResponse.genres)!!){
                        listOfGenre.add(genre!!.name!!)
                    }

                    val movie = DetailMovieEntity(
                        showResponse.id,
                        showResponse.title,
                        showResponse.backdropPath,
                        listOfGenre,
                        showResponse.voteCount,
                        showResponse.overview,
                        showResponse.originalTitle,
                        showResponse.runtime,
                        showResponse.posterPath,
                        showResponse.releaseDate,
                        showResponse.voteAverage
                    )
                    _isLoading.postValue(false)
                    movieResult.postValue(movie)
                }
            })
        }
        return movieResult
    }

    override fun getDetailTvShow(showId: String): MutableLiveData<DetailTvShowEntity> {
        _isLoading.value = true
        val showResult = MutableLiveData<DetailTvShowEntity>()
        CoroutineScope(IO).launch{
            remoteDataSource.getTvShow(showId, object : RemoteDataSource.CallbackLoadDetailTvShow{
                override fun onTvShowDetailsRecieved(showResponse: DetailTvShowResponse) {
                    val listOfGenre = ArrayList<String>()
                    val listOfSeasonData = ArrayList<TvShowSeasonEntity>()

                    for (genre in (showResponse.genres)!!){
                        listOfGenre.add(genre!!.name!!)
                    }

                    for (data in (showResponse.seasons)!!){
                        val season = TvShowSeasonEntity(
                            data?.airDate,
                            data?.episodeCount,
                            data?.id,
                            data?.name,
                            data?.overview,
                            data?.posterPath as String?,
                            data?.seasonNumber
                        )
                        listOfSeasonData.add(season)
                    }

                    val show = DetailTvShowEntity(
                        showResponse.id,
                        showResponse.name,
                        showResponse.backdropPath,
                        listOfGenre,
                        showResponse.voteCount,
                        showResponse.overview,
                        listOfSeasonData,
                        showResponse.originalName,
                        showResponse.episodeRunTime,
                        showResponse.posterPath,
                        showResponse.firstAirDate,
                        showResponse.voteAverage
                    )
                    _isLoading.postValue(false)
                    showResult.postValue(show)
                }
            })
        }
        return showResult
    }

}