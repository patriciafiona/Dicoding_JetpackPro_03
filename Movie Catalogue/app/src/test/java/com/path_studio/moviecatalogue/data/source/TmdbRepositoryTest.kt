package com.path_studio.moviecatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.verify
import com.path_studio.moviecatalogue.data.source.local.LocalDataSource
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowWithSeason
import com.path_studio.moviecatalogue.data.source.remote.RemoteDataSource
import com.path_studio.moviecatalogue.util.AppExecutors
import com.path_studio.moviecatalogue.util.DataDummy
import com.path_studio.moviecatalogue.utils.LiveDataTestUtil
import com.path_studio.moviecatalogue.utils.PagedListUtil
import com.path_studio.moviecatalogue.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class TmdbRepositoryTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val tmdbRepository = FakeTmdbRepository(remote, local, appExecutors)

    private val listMovie = DataDummy.generateDummyMovie()
    private val listTvShow = DataDummy.generateDummyTvShow()

    private val movieId = listMovie[0].movieId
    private val tvShowId = listTvShow[0].tvShowId

    private val detailMovie = DataDummy.generateDummyDetailMovie()[0]
    private val detailTvShow = DataDummy.generateDummyDetailTvShow()[0]
    private val detailTvShowWithSeason = DataDummy.generateDummyTvShowWithSeasonDetail()[0]

    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        tmdbRepository.getDiscoverMovies()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getAllMovies()
        assertNotNull(movieEntity.data)
        assertEquals(listMovie.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getAllTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTvShow()).thenReturn(dataSourceFactory)
        tmdbRepository.getDiscoverTvShow()

        val showEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getAllTvShow()
        assertNotNull(showEntity.data)
        assertEquals(listTvShow.size.toLong(), showEntity.data?.size?.toLong())
    }

    @Test
    fun getDetailMovies() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = detailMovie
        `when`(local.getMovieById(movieId.toString())).thenReturn(dummyMovie)

        val movieEntity = LiveDataTestUtil.getValue(tmdbRepository.getDetailMovie(detailMovie.movieId.toString()))
        verify(local).getMovieById(movieId.toString())
        assertNotNull(movieEntity)
        assertEquals(detailMovie.movieId, movieEntity.data?.movieId)
    }

    @Test
    fun getDetailTvShow() {
        val dummyTvShow = MutableLiveData<TvShowEntity>()
        dummyTvShow.value = detailTvShow
        `when`(local.getTvShowById(tvShowId.toString())).thenReturn(dummyTvShow)

        val showEntity = LiveDataTestUtil.getValue(tmdbRepository.getDetailTvShow(detailTvShow.tvShowId.toString()))
        verify(local).getTvShowById(tvShowId.toString())
        assertNotNull(showEntity)
        assertEquals(detailTvShow.tvShowId, showEntity.data?.tvShowId)
    }

    @Test
    fun getDetailTvShowWithSeason() {
        val dummyTvShowWithSeason = MutableLiveData<TvShowWithSeason>()
        dummyTvShowWithSeason.value = detailTvShowWithSeason
        `when`(local.getTvShowWithSeason(tvShowId.toString())).thenReturn(dummyTvShowWithSeason)

        val showEntity = LiveDataTestUtil.getValue(tmdbRepository.getTvShowWithSeason(detailTvShow.tvShowId.toString()))
        verify(local).getTvShowWithSeason(tvShowId.toString())
        assertNotNull(showEntity)
        assertEquals(detailTvShow.tvShowId, showEntity.mTvShow.tvShowId)
    }

    @Test
    fun getListFavoriteMovie(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceFactory)
        tmdbRepository.getFavoriteMovie()

        val movieEntity = Resource.success((PagedListUtil.mockPagedList((DataDummy.generateDummyMovie()))))
        verify(local).getFavoriteMovie()
        assertNotNull(movieEntity.data)
        assertEquals(listMovie.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getListFavoriteTvShow(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavoriteTvShow()).thenReturn(dataSourceFactory)
        tmdbRepository.getFavoriteTvShow()

        val showEntity = Resource.success((PagedListUtil.mockPagedList((DataDummy.generateDummyTvShow()))))
        verify(local).getFavoriteTvShow()
        assertNotNull(showEntity.data)
        assertEquals(listTvShow.size.toLong(), showEntity.data?.size?.toLong())
    }

}