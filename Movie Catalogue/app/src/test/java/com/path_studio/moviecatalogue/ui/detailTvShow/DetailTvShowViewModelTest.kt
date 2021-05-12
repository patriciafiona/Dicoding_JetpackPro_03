package com.path_studio.moviecatalogue.ui.detailTvShow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.path_studio.moviecatalogue.data.TmdbRepository
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowWithSeason
import com.path_studio.moviecatalogue.util.DataDummy
import com.path_studio.moviecatalogue.vo.Resource
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
    private val dummyTvShowWithSeason = DataDummy.generateDummyTvShowWithSeasonDetail()[0]
    private val showId = dummyDetailShow.tvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tmdbRepository: TmdbRepository

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(tmdbRepository)
    }

    @Test
    fun getDetailTvShow() {
        val showDetailDummy = MutableLiveData<Resource<TvShowEntity>>()
        val resource = Resource.success(dummyDetailShow)
        showDetailDummy.value = resource
        Mockito.`when`(tmdbRepository.getDetailTvShow(showId.toString())).thenReturn(showDetailDummy)

        val observer = Mockito.mock(Observer::class.java) as Observer<Resource<TvShowEntity>>
        viewModel.getDetailTvShow(showId.toString()).observeForever(observer)
        Mockito.verify(observer).onChanged(resource)
    }

    @Test
    fun getDetailTvShowWithSeason(){
        val showDetailDummy = MutableLiveData<TvShowWithSeason>()
        showDetailDummy.value = dummyTvShowWithSeason
        Mockito.`when`(tmdbRepository.getTvShowWithSeason(showId.toString())).thenReturn(showDetailDummy)

        val observer = Mockito.mock(Observer::class.java) as Observer<TvShowWithSeason>
        viewModel.getDetailTvShowWithSeason(showId.toString()).observeForever(observer)
    }

}