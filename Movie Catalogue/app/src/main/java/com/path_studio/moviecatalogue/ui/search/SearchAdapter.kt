package com.path_studio.moviecatalogue.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mancj.materialsearchbar.adapter.SuggestionsAdapter
import com.path_studio.moviecatalogue.R
import com.path_studio.moviecatalogue.data.SearchEntity

class SearchAdapter(inflater: LayoutInflater?, val activity: SearchActivity) : SuggestionsAdapter<SearchEntity,
        SearchAdapter.SuggestionHolder>(inflater) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchAdapter.SuggestionHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_suggestion, parent, false)
        return SuggestionHolder(view)
    }

    override fun onBindSuggestionHolder(
        suggestion: SearchEntity,
        holder: SearchAdapter.SuggestionHolder,
        position: Int
    ) {

        holder.name.text = suggestion.name

        holder.overview.text = suggestion.overview

        if (suggestion.posterPath != null){
            val posterURL = "https://image.tmdb.org/t/p/w500${suggestion.posterPath}"
            Glide.with(holder.itemView)
                .load(posterURL)
                .apply(RequestOptions().override(500, 500))
                .into(holder.poster)
        }else{
            holder.poster.setImageResource(R.drawable.no_image)
        }

        if (suggestion.backdropPath != null){
            val backdropURL = "https://www.themoviedb.org/t/p/w533_and_h300_bestv2${suggestion.backdropPath}"
            Glide.with(holder.itemView)
                .load(backdropURL)
                .apply(RequestOptions().override(500, 500))
                .into(holder.backDrop)
        }

//        holder.itemView.setOnClickListener {
//            //show detail page
//            val i = Intent(activity, DetailUserActivity::class.java)
//            i.putExtra(DetailUserActivity.EXTRA_USER, suggestion)
//            activity.startActivity(i)
//        }
    }

    override fun getSingleViewHeight(): Int {
        return 60
    }

    inner class SuggestionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.suggestion_title)
        var overview: TextView = itemView.findViewById(R.id.suggestion_overview)
        var poster: ImageView = itemView.findViewById(R.id.suggestion_poster)
        var backDrop: ImageView = itemView.findViewById(R.id.suggestion_backdrop)
    }

}