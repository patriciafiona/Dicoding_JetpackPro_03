package com.path_studio.moviecatalogue.ui.mainPage.favorite.favoriteMovie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.data.source.local.enitity.MovieEntity
import com.path_studio.moviecatalogue.databinding.ItemsMovieTvshowBinding
import com.path_studio.moviecatalogue.ui.detailMovie.DetailMovieActivity
import com.path_studio.moviecatalogue.util.Utils
import java.util.*

class FavoriteMovieAdapter : RecyclerView.Adapter<FavoriteMovieAdapter.FavMovieViewHolder>(){
    private val listFavMovie = ArrayList<MovieEntity>()

    fun setFavMovies(movies: List<MovieEntity>?) {
        if (movies == null) return
        this.listFavMovie.clear()
        this.listFavMovie.addAll(movies)

        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavMovieViewHolder {
        val itemsMovieTvshowBinding = ItemsMovieTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavMovieViewHolder(itemsMovieTvshowBinding)
    }

    override fun onBindViewHolder(holder: FavMovieViewHolder, position: Int) {
        val movie = listFavMovie[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listFavMovie.size

    inner class FavMovieViewHolder(private val binding: ItemsMovieTvshowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemDate.text = movie.releaseDate?.let { Utils.changeStringToDateFormat(it) }

                tvItemRating.rating = movie.voteAverage.toFloat()/2

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.movieId)
                    itemView.context.startActivity(intent)
                }

                val posterURL = "https://image.tmdb.org/t/p/w500/${movie.posterPath}"
                Glide.with(itemView.context)
                    .load(posterURL)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }
    }

}