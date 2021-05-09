package com.path_studio.moviecatalogue.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailTvShowEntity(
    val id: Int?,
    val name: String?,
    val backdropPath: String?,
    val genres:ArrayList<String>?,
    val voteCount: Int?,
    val overview: String?,
    val seasons: ArrayList<TvShowSeasonEntity>?,
    val originalName: String?,
    val runtime: List<Int?>?,
    val posterPath: String?,
    val releaseDate: String?,
    val voteAverage: Double?
):Parcelable