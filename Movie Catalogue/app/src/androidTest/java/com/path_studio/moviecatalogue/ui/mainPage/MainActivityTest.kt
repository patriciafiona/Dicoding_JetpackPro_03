package com.path_studio.moviecatalogue.ui.mainPage

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.util.DataDummy
import com.path_studio.moviecatalogue.util.EspressoIdlingResource
import com.path_studio.moviecatalogue.util.Utils
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest{
    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTvShow = DataDummy.generateDummyTvShow()

    private val dummyDetailMovie = DataDummy.generateDummyDetailMovie()
    private val dummyTvShowWithSeason = DataDummy.generateDummyTvShowWithSeasonDetail()[0]

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.navigation_movie)).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.navigation_movie)).perform(click())

        // "Mortal Kombat"
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(3, click()))

        onView(withId(R.id.movieTitle)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.movieTitle)).check(matches(withText(dummyDetailMovie[0].title)))
        onView(withId(R.id.movieTopTitle)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.movieTopTitle)).check(matches(withText(dummyDetailMovie[0].title)))

        onView(withId(R.id.movieRating)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

        onView(withId(R.id.movieReleaseDate)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.movieReleaseDate)).check(matches(withText(
                Utils.changeStringToDateFormat(
                    dummyDetailMovie[0].releaseDate!!
                )
        )))

        onView(withId(R.id.movieDuration)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.movieDuration)).check(matches(withText(
                Utils.changeMinuteToDurationFormat(
                    dummyDetailMovie[0].runtime!!
                )
        )))

        onView(withId(R.id.movieSinopsis)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.movieSinopsis)).check(matches(withText(dummyDetailMovie[0].overview)))
        onView(withId(R.id.btnFavoriteMovie)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.moviePoster)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.movieBackdrop)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

        onView(withId(R.id.btnBackPage)).perform(click())
    }

    @Test
    fun loadTvShow() {
        onView(withId(R.id.navigation_tvShow)).perform(click())
        onView(withId(R.id.rv_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withId(R.id.navigation_tvShow)).perform(click())

        // "The Falcon and the Winter Soldier"
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(7))
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(14, click()))

        onView(withId(R.id.showTitle)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.showTitle)).check(matches(withText(dummyTvShowWithSeason.mTvShow.name)))
        onView(withId(R.id.showTopTitle)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.showTopTitle)).check(matches(withText(dummyTvShowWithSeason.mTvShow.name)))

        onView(withId(R.id.showRating)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

        onView(withId(R.id.showReleaseDate)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.showReleaseDate)).check(matches(withText(
            Utils.changeStringDateToYear(
                dummyTvShowWithSeason.mTvShow.firstAirDate!!
            ).toString()
        )))

        onView(withId(R.id.showDuration)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.showDuration)).check(matches(withText(
                Utils.changeMinuteToDurationFormat(
                    dummyTvShowWithSeason.mTvShow.runtime!!
                )
        )))

        onView(withId(R.id.showSinopsis)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.showSinopsis)).check(matches(withText(dummyTvShowWithSeason.mTvShow.overview)))
        onView(withId(R.id.btnFavoriteshow)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.showPoster)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.showBackdrop)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

        onView(withId(R.id.rv_seasonDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_seasonDetail)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
            dummyTvShowWithSeason.mSeason.size))

        onView(withId(R.id.btnBackPage02)).perform(click())
    }

    @Test
    fun testMovieListExpansion() {
        onView(withId(R.id.navigation_movie)).perform(click())
        onView(withId(R.id.indicatorImage)).perform(click()) //expand page
        onView(withId(R.id.indicatorImage)).perform(click())// minimize expand page
    }

    @Test
    fun testTvShowListExpansion() {
        onView(withId(R.id.navigation_tvShow)).perform(click())
        onView(withId(R.id.indicatorImage2)).perform(click()) //expand page
        onView(withId(R.id.indicatorImage2)).perform(click())// minimize expand page
    }

}