package com.path_studio.moviecatalogue.ui.detailTvShow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.data.source.local.enitity.SeasonEntity
import com.path_studio.moviecatalogue.databinding.ItemsSeasonDetailBinding
import com.path_studio.moviecatalogue.util.Utils.changeStringToDateFormat

class SeasonDetailAdapter: RecyclerView.Adapter<SeasonDetailAdapter.SeasonViewHolder>() {

    private var listSeason = ArrayList<SeasonEntity>()

    fun setResult(res: List<SeasonEntity>) {
        this.listSeason.clear()
        this.listSeason.addAll(res)
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
        fun bind(season: SeasonEntity) {
            with(binding) {
                val temp1 = "Season ${season.seasonNumber}"
                seasonNumber.text = temp1

                val temp2 = "${season.airDate?.let { changeStringToDateFormat(it) }}| ${season.episodeCount} Eps."
                seasonYearAndTotalEpisode.text = temp2

                val temp3 = "Season ${season.seasonNumber} premiered on ${season.airDate?.let {
                    changeStringToDateFormat(
                        it
                    )
                }}."
                seasonPremierDetail.text = temp3

                seasonOverview.text = season.overview

                val posterURL = "https://image.tmdb.org/t/p/w500/${season.posterPath}"
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
