package com.path_studio.moviecatalogue.ui.detailTvShow

import android.annotation.SuppressLint
import android.app.ActionBar
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.databinding.ActivityDetailTvShowBinding
import com.path_studio.moviecatalogue.di.Injection
import com.path_studio.moviecatalogue.util.Utils
import com.path_studio.moviecatalogue.util.Utils.changeStringDateToYear

class DetailTvShowActivity : AppCompatActivity() {

    private lateinit var detailTvShowViewModel: DetailTvShowViewModel

    private lateinit var binding: ActivityDetailTvShowBinding

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //prepare view model for show Tv Show Details

        /*val extras = intent.extras
        if (extras != null) {
            val showId = extras.getLong(EXTRA_TV_SHOW)
            Log.e("showId", showId.toString())
            if (showId != 0L) {
                detailTvShowViewModel = DetailTvShowViewModel(Injection.provideImdbRepository(this))
                val showDetails = detailTvShowViewModel.getDetailTvShow(showId.toString())
                val seasonAdapter = SeasonDetailAdapter()

                with(binding.rvSeasonDetail) {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = seasonAdapter
                }

                showDetails.observe(this, { detail ->
                    val listOfSeason = detail.seasons
                    seasonAdapter.setSeason(listOfSeason!!)

                    showDetailShow(detail)
                })

                detailTvShowViewModel.getLoading().observe(this, {
                    if (it) skeleton.showSkeleton() else skeleton.showOriginal()
                })
            }
        }*/

        binding.btnBackPage02.setOnClickListener {
            super.onBackPressed() // or super.finish();
        }
    }

    /*@SuppressLint("UseCompatLoadingForDrawables")
    private fun showDetailShow(tvShowEntity: DetailTvShowEntity) {
        if (!tvShowEntity.name.equals("") && tvShowEntity.name != null){

            binding.showTopTitle.text = tvShowEntity.name
            binding.showTitle.text = tvShowEntity.name
            binding.showSinopsis.text = tvShowEntity.overview

            binding.showReleaseDate.text = changeStringDateToYear(tvShowEntity.releaseDate!!).toString()

            binding.showRating.rating = tvShowEntity.voteAverage!!.toFloat()/2

            binding.showDuration.text =
                Utils.changeMinuteToDurationFormat(
                    tvShowEntity.runtime?.get(0)!!
                )
            }

            val posterURL = "https://image.tmdb.org/t/p/w500${tvShowEntity.posterPath}"
            Glide.with(this)
                .load(posterURL)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(binding.showPoster)


            val backdropURL = "https://www.themoviedb.org/t/p/w533_and_h300_bestv2${tvShowEntity.backdropPath}"
            Glide.with(this)
                .load(backdropURL)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(binding.showBackdrop)
            binding.showBackdrop.alpha = 0.5F

            for (genre in tvShowEntity.genres!!){
                //set the properties for button
                val btnTag = Button(this)

                //set margin and create button
                val params: ActionBar.LayoutParams = ActionBar.LayoutParams(
                    ActionBar.LayoutParams.WRAP_CONTENT,
                    ActionBar.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(0, 0, 20, 0)

                btnTag.layoutParams = ActionBar.LayoutParams(params)
                btnTag.text = genre
                btnTag.background = this.getDrawable(R.drawable.rounded_button)

                //set padding
                btnTag.setPadding(15, 10, 15, 10)

                //add button to the layout
                binding.showGenres.addView(btnTag)
            }

    }*/

}