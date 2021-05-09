package com.path_studio.moviecatalogue.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailMovieEntity(
    val id: Int?,
    val title: String?,
    val backdropPath: String?,
    val genres:ArrayList<String>?,
    val voteCount: Int?,
    val overview: String?,
    val originalTitle: String?,
    val runtime: Int?,
    val posterPath: String?,
    val releaseDate: String?,
    val voteAverage: Double?
):Parcelable
