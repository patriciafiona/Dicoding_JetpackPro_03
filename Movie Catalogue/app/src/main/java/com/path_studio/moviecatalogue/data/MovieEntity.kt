package com.path_studio.moviecatalogue.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieEntity(
    val overview: String?,
    val originalTitle: String?,
    val title: String?,
    val posterPath: String?,
    val backdropPath: String?,
    val releaseDate: String?,
    val voteAverage: Double?,
    val id: Long
): Parcelable