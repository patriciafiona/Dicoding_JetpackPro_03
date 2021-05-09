package com.path_studio.moviecatalogue.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.path_studio.moviecatalogue.BuildConfig
import com.path_studio.moviecatalogue.data.source.remote.api.ApiConfig
import com.path_studio.moviecatalogue.data.source.remote.response.*
import com.path_studio.moviecatalogue.util.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.await
import java.io.IOException

class RemoteDataSource {

    companion object {
        @Volatile
        private var instance: RemoteDataSource ? = null
        private const val API_KEY = BuildConfig.TMDB_API_KEY
        private const val language = "en-US"

        fun getInstance(): RemoteDataSource =
                instance ?: synchronized(this) {
                    instance ?: RemoteDataSource()
                }
    }

    suspend fun getSearchResult(title: String, callback: CallbackLoadSearchResult) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getSearchResult(API_KEY, language, title, "1").await().results.let{
                listResult -> callback.onSearchResultRecieved((
                listResult
                ))
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getDiscoverMovie(): LiveData<ApiResponse<List<DiscoverMovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovieResponse = MutableLiveData<ApiResponse<List<DiscoverMovieResponse>>>()
        CoroutineScope(IO).launch {
            try{
                val response = ApiConfig.getApiService().getDiscoverMovie(API_KEY, language).await()
                resultMovieResponse.postValue(ApiResponse.success(response.results!!))
            }catch (e: IOException){
                Log.e("getDiscoverMovie Error", e.message.toString())
                resultMovieResponse.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return  resultMovieResponse
    }

    suspend fun getDiscoverTvShow(): LiveData<ApiResponse<List<DiscoverMovieResponse>>> {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getDiscoverTvShow(API_KEY, language).await().results.let{
            listShow -> callback.onTvShowRecieved((
                listShow
                ))
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getMovie(movieId: String, callback: CallbackLoadDetailMovie){
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getDetailMovie(movieId, API_KEY, language).await().let{
            movie -> callback.onMovieDetailsRecieved((
                movie
                ))
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTvShow(showId: String, callback: CallbackLoadDetailTvShow){
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getDetailTvShow(showId, API_KEY, language).await().let{
            show -> callback.onTvShowDetailsRecieved((
                show
                ))
            EspressoIdlingResource.decrement()
        }
    }

    interface CallbackLoadDiscoverMovie{
        fun onMoviesRecieved(showResponse: List<ResultsItemMovie>)
    }

    interface CallbackLoadDiscoverTvShow{
        fun onTvShowRecieved(showResponse: List<ResultsItemTvShow>)
    }

    interface CallbackLoadDetailMovie{
        fun onMovieDetailsRecieved(showResponse: DetailMovieResponse)
    }

    interface CallbackLoadDetailTvShow{
        fun onTvShowDetailsRecieved(showResponse: DetailTvShowResponse)
    }

    interface CallbackLoadSearchResult{
        fun onSearchResultRecieved(showResponse: List<SearchResultsItem?>?)
    }

}