package com.path_studio.moviecatalogue.ui.detailTvShow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.path_studio.moviecatalogue.data.TmdbRepository
import com.path_studio.moviecatalogue.data.entities.DetailTvShowEntity
import com.path_studio.moviecatalogue.util.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {

    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyDetailShow= DataDummy.generateDummyDetailTvShow()[0]
    private val showId = dummyDetailShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tmdbRepository: TmdbRepository

    @Mock
    private lateinit var observer: Observer<DetailTvShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(tmdbRepository)
        viewModel.getDetailTvShow(showId.toString())
    }

    @Test
    fun getDetailTvShow() {
        val showDummy = MutableLiveData<DetailTvShowEntity>()
        showDummy.value = dummyDetailShow

        Mockito.`when`(tmdbRepository.getDetailTvShow(showId.toString())).thenReturn(showDummy)

        Mockito.verify(tmdbRepository).getDetailTvShow(showId.toString())

        val showData = viewModel.getDetailTvShow(showId.toString()).value as DetailTvShowEntity

        assertNotNull(showData)

        assertEquals(dummyDetailShow.posterPath, showData.posterPath)
        assertEquals(dummyDetailShow.backdropPath, showData.backdropPath)
        assertEquals(dummyDetailShow.id, showData.id)
        assertEquals(dummyDetailShow.originalName, showData.originalName)
        assertEquals(dummyDetailShow.name, showData.name)
        assertEquals(dummyDetailShow.overview, showData.overview)
        assertEquals(dummyDetailShow.voteAverage, showData.voteAverage)
        assertEquals(dummyDetailShow.voteCount, showData.voteCount)
        assertEquals(dummyDetailShow.genres, showData.genres)
        assertEquals(dummyDetailShow.runtime, showData.runtime)
        assertEquals(dummyDetailShow.releaseDate, showData.releaseDate)
        assertEquals(dummyDetailShow.seasons, showData.seasons)

        viewModel.getDetailTvShow(showId.toString()).observeForever(observer)
        Mockito.verify(observer).onChanged(dummyDetailShow)
    }

}