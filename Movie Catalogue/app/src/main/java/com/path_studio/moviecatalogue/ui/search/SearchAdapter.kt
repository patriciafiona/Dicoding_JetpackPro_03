package com.path_studio.moviecatalogue.ui.search

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mancj.materialsearchbar.adapter.SuggestionsAdapter
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.data.entities.SearchEntity
import com.path_studio.moviecatalogue.databinding.ItemRowSuggestionBinding
import com.path_studio.moviecatalogue.ui.detailMovie.DetailMovieActivity
import com.path_studio.moviecatalogue.ui.detailTvShow.DetailTvShowActivity

class SearchAdapter(inflater: LayoutInflater?) : SuggestionsAdapter<SearchEntity,
        SearchAdapter.SuggestionHolder>(inflater) {

    private var listResult = ArrayList<SearchEntity>()

    fun setResult(res: List<SearchEntity>) {
        this.listResult.clear()
        this.listResult.addAll(res)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionHolder {
        val itemSearchBinding = ItemRowSuggestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SuggestionHolder(itemSearchBinding)
    }

    override fun onBindSuggestionHolder(
        suggestion: SearchEntity,
        holder: SuggestionHolder,
        position: Int
    ) {
        val result = listResult[position]
        holder.bind(result)
    }

    override fun getItemCount(): Int = listResult.size

    override fun getSingleViewHeight(): Int {
        return 60
    }

    class SuggestionHolder(private val binding: ItemRowSuggestionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(suggestion: SearchEntity) {
            with(binding) {
                suggestionTitle.text = suggestion.name

                suggestionOverview.text = suggestion.overview

                if (suggestion.posterPath != null){
                    val posterURL = "https://image.tmdb.org/t/p/w500${suggestion.posterPath}"
                    Glide.with(itemView.context)
                        .load(posterURL)
                        .apply(RequestOptions().override(500, 500))
                        .into(suggestionPoster)
                }else{
                    suggestionPoster.setImageResource(R.drawable.no_image)
                }

                if (suggestion.backdropPath != null){
                    val backdropURL = "https://www.themoviedb.org/t/p/w533_and_h300_bestv2${suggestion.backdropPath}"
                    Glide.with(itemView.context)
                        .load(backdropURL)
                        .apply(RequestOptions().override(500, 500))
                        .into(suggestionBackdrop)
                }

                itemView.setOnClickListener {
                    //show detail page
                    if(suggestion.mediaType == "tv"){
                        val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                        intent.putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, suggestion.id)
                        itemView.context.startActivity(intent)
                    }else{
                        val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                        intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, suggestion.id)
                        itemView.context.startActivity(intent)
                    }

                }
            }
        }
    }
}