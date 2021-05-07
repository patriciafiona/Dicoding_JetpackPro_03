package com.path_studio.moviecatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.path_studio.moviecatalogue.data.source.remote.RemoteDataSource
import com.path_studio.moviecatalogue.util.DataDummy
import com.path_studio.moviecatalogue.util.LiveDataTestUtil
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class TmdbRepositoryTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val TmdbRepository = FakeTmdbRepository(remote)

    private val listMovieResponses = DataDummy.generateDummyMovieResponse()
    private val listTvShowResponses = DataDummy.generateDummyTvShowResponse()

    private val movieId = listMovieResponses[0].id
    private val tvShowId = listTvShowResponses[0].id

    private val detailMovie = DataDummy.generateDummyDetailMovieResponse()[0]
    private val detailTvShow = DataDummy.generateDummyDetailTvShowResponse()[0]

    @Test
    fun getAllMovies() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[0] as RemoteDataSource.CallbackLoadDiscoverMovie).onMoviesRecieved(listMovieResponses)
                null
            }.`when`(remote).getDiscoverMovie(any())
        }

        val dataListMovie = LiveDataTestUtil.getValue(TmdbRepository.getDiscoverMovies())

        runBlocking {
            verify(remote).getDiscoverMovie(any())
        }

        assertNotNull(dataListMovie)
        assertEquals(listMovieResponses.size.toLong(), dataListMovie.size.toLong())
    }

    @Test
    fun getAllTvShow() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[0] as RemoteDataSource.CallbackLoadDiscoverTvShow).onTvShowRecieved(listTvShowResponses)
                null
            }.`when`(remote).getDiscoverTvShow(any())
        }

        val dataListTvShow = LiveDataTestUtil.getValue(TmdbRepository.getDiscoverTvShow())

        runBlocking {
            verify(remote).getDiscoverTvShow(any())
        }

        assertNotNull(dataListTvShow)
        assertEquals(listTvShowResponses.size.toLong(), dataListTvShow.size.toLong())
    }

    @Test
    fun getDetailMovies() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[1] as RemoteDataSource.CallbackLoadDetailMovie).onMovieDetailsRecieved(detailMovie)
                null
            }.`when`(remote).getMovie(eq(movieId.toString()), any())
        }

        val dataMovie = LiveDataTestUtil.getValue(TmdbRepository.getDetailMovie(movieId.toString()))

        runBlocking {
            verify(remote).getMovie(eq(movieId.toString()), any())
        }

        assertNotNull(dataMovie)
        assertEquals(detailMovie.id, dataMovie.id)
    }

    @Test
    fun getDetailTvShow() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[1] as RemoteDataSource.CallbackLoadDetailTvShow).onTvShowDetailsRecieved(detailTvShow)
                null
            }.`when`(remote).getTvShow(eq(tvShowId.toString()), any())
        }

        val dataTvShow = LiveDataTestUtil.getValue(TmdbRepository.getDetailTvShow(tvShowId.toString()))

        runBlocking {
            verify(remote).getTvShow(eq(tvShowId.toString()), any())
        }

        assertNotNull(dataTvShow)
        assertEquals(detailTvShow.id, dataTvShow.id)
    }

}