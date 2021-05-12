package com.path_studio.moviecatalogue.ui.mainPage.favorite.favoriteTvShow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.databinding.ItemsMovieTvshowBinding
import com.path_studio.moviecatalogue.ui.detailTvShow.DetailTvShowActivity
import com.path_studio.moviecatalogue.util.Utils
import java.util.*

class FavoriteTvShowAdapter : RecyclerView.Adapter<FavoriteTvShowAdapter.FavTvShowViewHolder>(){
    private val listFavShow = ArrayList<TvShowEntity>()

    fun setFavShows(shows: List<TvShowEntity>?) {
        if (shows == null) return
        this.listFavShow.clear()
        this.listFavShow.addAll(shows)

        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavTvShowViewHolder {
        val itemsMovieTvShowBinding = ItemsMovieTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavTvShowViewHolder(itemsMovieTvShowBinding)
    }

    override fun onBindViewHolder(holder: FavTvShowViewHolder, position: Int) {
        val show = listFavShow[position]
        holder.bind(show)
    }

    override fun getItemCount(): Int = listFavShow.size

    inner class FavTvShowViewHolder(private val binding: ItemsMovieTvshowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(show: TvShowEntity) {
            with(binding) {
                tvItemTitle.text = show.name

                tvItemDate.text = Utils.changeStringToDateFormat(show.firstAirDate!!)

                tvItemRating.rating = show.voteAverage!!.toFloat()/2

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, show.tvShowId)
                    itemView.context.startActivity(intent)
                }

                val posterURL = "https://image.tmdb.org/t/p/w500/${show.posterPath}"
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