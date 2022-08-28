package com.path_studio.moviecatalogue.ui.detailMovie

import android.annotation.SuppressLint
import android.app.ActionBar
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.path_studio.moviecatalogue.util.Utils.changeMinuteToDurationFormat
import com.path_studio.moviecatalogue.util.Utils.changeStringToDateFormat
import com.path_studio.moviecatalogue.viewmodel.ViewModelFactory
import com.path_studio.moviecatalogue.vo.Status
import org.json.JSONArray

class DetailMovieActivity : AppCompatActivity(){
    private lateinit var detailMovieViewModel: DetailMovieViewModel

    private lateinit var binding: ActivityDetailMovieBinding
    private var currentFavState = false

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras

        val factory = ViewModelFactory.getInstance(this)
        val detailMovieViewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        if (extras != null) {
            val movieId = extras.getLong(EXTRA_MOVIE)
            if (movieId != 0L) {
                detailMovieViewModel.getDetailMovie(movieId.toString()).observe(this) { movie ->
                    if (movie != null) {
                        when (movie.status) {
                            Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                            Status.SUCCESS -> {
                                Log.e("result", movie.data.toString())
                                binding.progressBar.visibility = View.GONE
                                movie.data?.let { showDetailMovie(it) }
                                currentFavState = movie.data?.favorite ?: false
                                setFavoriteState(currentFavState)
                            }
                            Status.ERROR -> {
                                binding.progressBar.visibility = View.GONE
                                Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }
        }

        binding.btnBackPage.setOnClickListener {
            super.onBackPressed()
        }

        binding.btnFavoriteMovie.setOnClickListener {
            detailMovieViewModel.setFavorite()
            currentFavState = !currentFavState
            setFavoriteState(currentFavState)
            setFavStatusToast(currentFavState)
        }
    }

    private fun setFavoriteState(state: Boolean){
        if (state) {
            binding.btnFavoriteMovie.setImageResource(R.drawable.ic_baseline_favorite_red)
        } else {
            binding.btnFavoriteMovie.setImageResource(R.drawable.ic_baseline_favorite_white)
        }
    }

    private fun setFavStatusToast(state: Boolean){
        if (state) {
            Toast.makeText(this, R.string.successAddedToDatabase, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, R.string.successRemovedToDatabase, Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun showDetailMovie(movieEntity: MovieEntity) {
        if (movieEntity.title != ""){
            binding.movieTopTitle.text = movieEntity.title
            binding.movieTitle.text = movieEntity.title
            binding.movieSinopsis.text = movieEntity.overview

            binding.movieReleaseDate.text = movieEntity.releaseDate?.let { changeStringToDateFormat(it) }

            binding.movieRating.rating = movieEntity.voteAverage.toFloat()/2

            binding.movieDuration.text = movieEntity.runtime?.let { changeMinuteToDurationFormat(it) }

            val posterURL = "https://image.tmdb.org/t/p/w500${movieEntity.posterPath}"
            Glide.with(this)
                .load(posterURL)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(binding.moviePoster)

            val backdropURL = "https://www.themoviedb.org/t/p/w533_and_h300_bestv2${movieEntity.backdropPath}"
            Glide.with(this)
                .load(backdropURL)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(binding.movieBackdrop)
            binding.movieBackdrop.alpha = 0.5F

            val listGenre = ArrayList<String>()
            val jArray = JSONArray(movieEntity.genres)
            for (i in 0 until jArray.length()) {
                listGenre.add(jArray.getString(i))
            }

            binding.movieGenres.removeAllViews()
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
                binding.movieGenres.addView(btnTag)
            }
        }
    }

}