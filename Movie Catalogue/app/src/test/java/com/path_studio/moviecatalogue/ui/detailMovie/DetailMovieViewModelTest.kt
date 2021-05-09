package com.path_studio.moviecatalogue.ui.detailMovie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.path_studio.moviecatalogue.data.entities.DetailMovieEntity
import com.path_studio.moviecatalogue.data.TmdbRepository
import com.path_studio.moviecatalogue.util.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyDetailMovie = DataDummy.generateDummyDetailMovie()[0]
    private val movieId = dummyDetailMovie.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tmdbRepository: TmdbRepository

    @Mock
    private lateinit var observer: Observer<DetailMovieEntity>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(tmdbRepository)
        viewModel.getDetailMovie(movieId.toString())
    }

    @Test
    fun getDetailMovie() {
        val movieDummy = MutableLiveData<DetailMovieEntity>()
        movieDummy.value = dummyDetailMovie

        `when`(tmdbRepository.getDetailMovie(movieId.toString())).thenReturn(movieDummy)

        verify(tmdbRepository).getDetailMovie(movieId.toString())

        val movieData = viewModel.getDetailMovie(movieId.toString()).value as DetailMovieEntity

        assertNotNull(movieData)

        assertEquals(dummyDetailMovie.posterPath, movieData.posterPath)
        assertEquals(dummyDetailMovie.backdropPath, movieData.backdropPath)
        assertEquals(dummyDetailMovie.id, movieData.id)
        assertEquals(dummyDetailMovie.originalTitle, movieData.originalTitle)
        assertEquals(dummyDetailMovie.title, movieData.title)
        assertEquals(dummyDetailMovie.overview, movieData.overview)
        assertEquals(dummyDetailMovie.voteAverage, movieData.voteAverage)
        assertEquals(dummyDetailMovie.voteCount, movieData.voteCount)
        assertEquals(dummyDetailMovie.genres, movieData.genres)
        assertEquals(dummyDetailMovie.runtime, movieData.runtime)
        assertEquals(dummyDetailMovie.releaseDate, movieData.releaseDate)

        viewModel.getDetailMovie(movieId.toString()).observeForever(observer)
        verify(observer).onChanged(dummyDetailMovie)
    }

}