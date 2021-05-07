package com.path_studio.moviecatalogue.ui.detailTvShow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.data.TvShowSeasonEntity
import com.path_studio.moviecatalogue.databinding.ItemsSeasonDetailBinding
import com.path_studio.moviecatalogue.util.Utils.changeStringToDateFormat

class SeasonDetailAdapter: RecyclerView.Adapter<SeasonDetailAdapter.SeasonViewHolder>() {

    private var listSeason = ArrayList<TvShowSeasonEntity>()

    fun setSeason(season: List<TvShowSeasonEntity>) {
        if (season == null) return
        this.listSeason.clear()
        this.listSeason.addAll(season)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder {
        val itemsSeasonDetailBinding = ItemsSeasonDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeasonViewHolder(itemsSeasonDetailBinding)
    }

    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) {
        val season = listSeason[position]
        holder.bind(season)
    }

    override fun getItemCount(): Int = listSeason.size


    class SeasonViewHolder(private val binding: ItemsSeasonDetailBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(season: TvShowSeasonEntity) {
            with(binding) {
                val temp1 = "Season ${season.season_number}"
                seasonNumber.text = temp1

                val temp2 = "${changeStringToDateFormat(season.air_date!!)}| ${season.episode_count} Eps."
                seasonYearAndTotalEpisode.text = temp2

                val temp3 = "Season ${season.season_number} premiered on ${changeStringToDateFormat(season.air_date!!)}."
                seasonPremierDetail.text = temp3

                seasonOverview.text = season.overview

                val posterURL = "https://image.tmdb.org/t/p/w500/${season.poster_path}"
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