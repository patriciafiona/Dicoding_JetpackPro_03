package com.path_studio.moviecatalogue.ui.detailMovie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.path_studio.moviecatalogue.data.TmdbRepository
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.util.DataDummy
import com.path_studio.moviecatalogue.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyDetailMovie = DataDummy.generateDummyDetailMovie()[0]
    private val movieId = dummyDetailMovie.movieId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tmdbRepository: TmdbRepository

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(tmdbRepository)
    }

    @Test
    fun getDetailMovie() {
        val movieDummy = MutableLiveData<Resource<MovieEntity>>()
        val resource = Resource.success(dummyDetailMovie)
        movieDummy.value = resource
        `when`(tmdbRepository.getDetailMovie(movieId.toString())).thenReturn(movieDummy)

        val observer = mock(Observer::class.java) as Observer<Resource<MovieEntity>>
        viewModel.getDetailMovie(movieId.toString()).observeForever(observer)
        verify(observer).onChanged(resource)
    }

}