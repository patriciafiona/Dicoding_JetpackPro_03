package com.path_studio.moviecatalogue.ui.detailTvShow

import android.annotation.SuppressLint
import android.app.ActionBar
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.databinding.ActivityDetailTvShowBinding
import com.path_studio.moviecatalogue.di.Injection
import com.path_studio.moviecatalogue.ui.detailMovie.DetailMovieActivity
import com.path_studio.moviecatalogue.ui.detailMovie.DetailMovieViewModel
import com.path_studio.moviecatalogue.util.Utils
import com.path_studio.moviecatalogue.util.Utils.changeStringDateToYear
import com.path_studio.moviecatalogue.viewmodel.ViewModelFactory
import com.path_studio.moviecatalogue.vo.Status
import org.json.JSONArray

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

        val extras = intent.extras
        if (extras != null) {
            val showId = extras.getLong(EXTRA_TV_SHOW)
            val isFavStatus = extras.getBoolean(DetailMovieActivity.IS_FAVORITE)

            if (showId != 0L) {
                val factory = ViewModelFactory.getInstance(this)
                val viewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]

                //call this first to get season details
                viewModel.getDetailTvShow(showId.toString(), isFavStatus).observe(this, { show ->
                    if (show != null) {
                        when (show.status) {
                            Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                            Status.SUCCESS -> {
                                binding.progressBar.visibility = View.GONE
                                showDetailShow(show.data!!)
                            }
                            Status.ERROR -> {
                                binding.progressBar.visibility = View.GONE
                                Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })

                //Get Season Details
                val seasonAdapter = SeasonDetailAdapter()
                viewModel.getDetailTvShowWithSeason(showId.toString()).observe(this, { detail ->
                    if (detail != null) {
                        seasonAdapter.setResult(detail.mSeason)
                    }
                })

                with(binding.rvSeasonDetail) {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = seasonAdapter
                }
            }
        }

        binding.btnBackPage02.setOnClickListener {
            super.onBackPressed()
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun showDetailShow(tvShowEntity: TvShowEntity) {
        if (tvShowEntity.name != "") {

            binding.showTopTitle.text = tvShowEntity.name
            binding.showTitle.text = tvShowEntity.name
            binding.showSinopsis.text = tvShowEntity.overview

            binding.showReleaseDate.text =
                changeStringDateToYear(tvShowEntity.firstAirDate!!).toString()

            binding.showRating.rating = tvShowEntity.voteAverage!!.toFloat() / 2

            binding.showDuration.text =
                Utils.changeMinuteToDurationFormat(
                    tvShowEntity.runtime!!
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


            val backdropURL =
                "https://www.themoviedb.org/t/p/w533_and_h300_bestv2${tvShowEntity.backdropPath}"
            Glide.with(this)
                .load(backdropURL)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(binding.showBackdrop)
            binding.showBackdrop.alpha = 0.5F

            val listGenre = ArrayList<String>()
            val jArray = JSONArray(tvShowEntity.genres)
            for (i in 0 until jArray.length()) {
                listGenre.add(jArray.getString(i))
            }

            for (genre in listGenre){
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
    }

}