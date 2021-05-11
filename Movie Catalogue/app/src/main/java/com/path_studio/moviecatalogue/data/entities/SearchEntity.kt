package com.path_studio.moviecatalogue.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchEntity(
    val id: Long?,
    val name: String?,
    val posterPath: String?,
    val backdropPath: String?,
    val mediaType: String,
    val overview: String?,
    val voteAverage: Double?,
    val releaseOrAirDate: String?
): Parcelable