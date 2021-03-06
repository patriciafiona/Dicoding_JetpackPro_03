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

    //No need to connect to Room, so keep the code
    suspend fun getSearchResult(title: String, callback: CallbackLoadSearchResult) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getSearchResult(API_KEY, language, title, "1").await().results.let{
                listResult -> callback.onSearchResultRecieved((
                listResult
                ))
            EspressoIdlingResource.decrement()
        }
    }

    interface CallbackLoadSearchResult{
        fun onSearchResultRecieved(showResponse: List<SearchResultsItem?>?)
    }
    //---------------------------------------------------------------------------------------------

    fun getDiscoverMovie(): LiveData<ApiResponse<List<ResultsItemMovie>>> {
        EspressoIdlingResource.increment()
        val resultMovieResponse = MutableLiveData<ApiResponse<List<ResultsItemMovie>>>()
        CoroutineScope(IO).launch {
            try{
                val response = ApiConfig.getApiService().getDiscoverMovie(API_KEY, language).await()
                resultMovieResponse.postValue(ApiResponse.success(response.results))
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

    fun getDiscoverTvShow(): LiveData<ApiResponse<List<ResultsItemTvShow>>> {
        EspressoIdlingResource.increment()
        val resultTvShowResponse = MutableLiveData<ApiResponse<List<ResultsItemTvShow>>>()
        CoroutineScope(IO).launch {
            try{
                val response = ApiConfig.getApiService().getDiscoverTvShow(API_KEY, language).await()
                resultTvShowResponse.postValue(ApiResponse.success(response.results))
            }catch (e: IOException){
                Log.e("getDiscoverTvShow Error", e.message.toString())
                resultTvShowResponse.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return  resultTvShowResponse
    }

    fun getMovie(movieId: String): LiveData<ApiResponse<DetailMovieResponse>> {
        EspressoIdlingResource.increment()
        val resultsItemMovie = MutableLiveData<ApiResponse<DetailMovieResponse>>()
        CoroutineScope(IO).launch {
            try{
                val response = ApiConfig.getApiService().getDetailMovie(movieId, API_KEY, language).await()
                resultsItemMovie.postValue(ApiResponse.success(response))
            }catch (e: IOException){
                Log.e("getMovie Error", e.message.toString())
                resultsItemMovie.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        DetailMovieResponse()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return  resultsItemMovie
    }

    fun getTvShow(showId: String): LiveData<ApiResponse<DetailTvShowResponse>> {
        EspressoIdlingResource.increment()
        val resultsItemTvShow = MutableLiveData<ApiResponse<DetailTvShowResponse>>()
        CoroutineScope(IO).launch {
            try{
                val response = ApiConfig.getApiService().getDetailTvShow(showId, API_KEY, language).await()
                resultsItemTvShow.postValue(ApiResponse.success(response))
            }catch (e: IOException){
                Log.e("getMovie Error", e.message.toString())
                resultsItemTvShow.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        DetailTvShowResponse()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return  resultsItemTvShow
    }

}