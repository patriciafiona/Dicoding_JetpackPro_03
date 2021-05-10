package com.path_studio.moviecatalogue.ui.tvShow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.data.source.local.enitity.TvShowEntity
import com.path_studio.moviecatalogue.databinding.ItemsMovieTvshowBinding
import com.path_studio.moviecatalogue.ui.detailTvShow.DetailTvShowActivity

class TvShowAdapter: PagedListAdapter<TvShowEntity, TvShowAdapter.TvShowViewHolder>(TvShowAdapter.DIFF_CALLBACK)  {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.tvShowId == newItem.tvShowId
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowAdapter.TvShowViewHolder {
        val itemsTvShowBinding = ItemsMovieTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowAdapter.TvShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowAdapter.TvShowViewHolder, position: Int) {
        val show = getItem(position)
        if (show != null) {
            holder.bind(show)
        }
    }

    class TvShowViewHolder(private val binding: ItemsMovieTvshowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(show: TvShowEntity) {
            with(binding) {
                tvItemTitle.text = show.name

                //tvItemDate.text = changeStringToDateFormat(show.firstAirDate!!)

                //tvItemRating.rating = show.voteAverage!!.toFloat()/2

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