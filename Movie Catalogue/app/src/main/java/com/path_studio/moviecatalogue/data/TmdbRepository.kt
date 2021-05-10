package com.path_studio.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.path_studio.moviecatalogue.data.source.local.LocalDataSource
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.data.source.remote.ApiResponse
import com.path_studio.moviecatalogue.data.source.remote.RemoteDataSource
import com.path_studio.moviecatalogue.data.source.remote.response.ResultsItemMovie
import com.path_studio.moviecatalogue.data.source.remote.response.ResultsItemTvShow
import com.path_studio.moviecatalogue.util.AppExecutors
import com.path_studio.moviecatalogue.vo.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TmdbRepository private constructor(private val remoteDataSource: RemoteDataSource,
                                         private val localDataSource: LocalDataSource,
                                         private val appExecutors: AppExecutors
) : TmdbDataSource {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    companion object {
        @Volatile
        private var instance: TmdbRepository? = null

        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): TmdbRepository =
            instance ?: synchronized(this) {
                instance ?: TmdbRepository(remoteData, localData, appExecutors).apply {
                    instance = this
                }
            }
    }

    /*override fun getSearchResult(title: String): LiveData<List<SearchEntity>> {
        _isLoading.value = true
        val listOfResult = MutableLiveData<List<SearchEntity>>()
        CoroutineScope(IO).launch{
            remoteDataSource.getSearchResult(title, object : RemoteDataSource.CallbackLoadSearchResult{
                override fun onSearchResultRecieved(showResponse: List<SearchResultsItem?>?) {
                    val res = ArrayList<SearchEntity>()
                    if (showResponse != null) {
                        for(responseSearch in showResponse){
                            if(responseSearch!!.mediaType == "tv" || responseSearch.mediaType == "movie"){
                                val resSearch = SearchEntity(
                                    responseSearch.id,
                                    if(responseSearch.mediaType == "tv") responseSearch.name else responseSearch.title,
                                    responseSearch.posterPath,
                                    responseSearch.backdropPath,
                                    responseSearch.mediaType,
                                    responseSearch.overview,
                                    responseSearch.voteAverage,
                                    if(responseSearch.mediaType == "tv") responseSearch.firstAirDate else responseSearch.releaseDate
                                )

                                if(!res.contains(resSearch)){
                                    res.add(resSearch)
                                }
                            }
                        }
                    }
                    _isLoading.postValue(false)
                    listOfResult.postValue(res)
                }
            })
        }
        return listOfResult
    }*/

    override fun getDiscoverMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object: NetworkBoundResource<PagedList<MovieEntity>, List<ResultsItemMovie>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder().apply {
                    setEnablePlaceholders(false)
                    setInitialLoadSizeHint(4)
                    setPageSize(4)
                }.build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<ResultsItemMovie>>> =
                remoteDataSource.getDiscoverMovie()

            public override fun saveCallResult(data: List<ResultsItemMovie>) {
                val movies = ArrayList<MovieEntity>()
                for(response in data){
                    val movie = MovieEntity(
                        response.id,
                        response.title,
                        response.overview,
                        response.posterPath,
                        response.backdropPath,
                        response.releaseDate,
                        response.voteAverage,
                        null,
                         false
                    )
                    movies.add(movie)
                }
                localDataSource.insertMovies(movies)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(movieId: String): LiveData<MovieEntity> =
        localDataSource.getMovieById(movieId)

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }

    override fun getDiscoverTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object: NetworkBoundResource<PagedList<TvShowEntity>, List<ResultsItemTvShow>>(appExecutors){
            public override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder().apply {
                    setEnablePlaceholders(false)
                    setInitialLoadSizeHint(4)
                    setPageSize(4)
                }.build()
                return LivePagedListBuilder(localDataSource.getAllTvShow(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<ResultsItemTvShow>>> =
                remoteDataSource.getDiscoverTvShow()

            public override fun saveCallResult(data: List<ResultsItemTvShow>) {
                val shows = ArrayList<TvShowEntity>()
                for(response in data) {
                    val show = TvShowEntity(
                        response.id,
                        response.name,
                        response.overview,
                        response.posterPath,
                        response.backdropPath,
                        null,
                        null,
                        null,
                        false
                    )
                    shows.add(show)
                }
                localDataSource.insertTvShow(shows)
            }
        }.asLiveData()
    }

    /*override fun getTvShowWithSeason(showId: String): LiveData<Resource<TvShowWithSeason>> {
        return object : NetworkBoundResource<TvShowWithSeason, List<SeasonsItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowWithSeason> =
                localDataSource.getTvShowWithSeason(showId)

            override fun shouldFetch(data: TvShowWithSeason?): Boolean =
                data?.mSeason == null || data.mSeason.isEmpty()

            override suspend fun createCall(): LiveData<ApiResponse<DetailTvShowResponse>> =
                remoteDataSource.getTvShow(showId)

            override fun saveCallResult(data: List<SeasonsItem>) {
                val seasonList = ArrayList<SeasonEntity>()
                for (response in data) {
                    val season = SeasonEntity(
                        response.id,
                        "0",
                        response.name,
                        response.overview,
                        response.airDate,
                        response.seasonNumber,
                        response.episodeCount,
                        response.posterPath.toString())

                    seasonList.add(season)
                }

                localDataSource.insertSeason(seasonList)
            }
        }.asLiveData()
    }*/

    override fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder().apply {
            setEnablePlaceholders(false)
            setInitialLoadSizeHint(4)
            setPageSize(4)
        }.build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShow(), config).build()
    }

    override fun getDetailTvShow(showId: String): LiveData<TvShowEntity> =
        localDataSource.getTvShowById(showId)

    override fun setFavoriteMovie(movie: MovieEntity){
        CoroutineScope(IO).launch {
            localDataSource.setMovieFavorite(movie)
        }
    }

    override fun setFavoriteTvShow(tvShow: TvShowEntity){
        CoroutineScope(IO).launch {
            localDataSource.setTvShowFavorite(tvShow)
        }
    }

}