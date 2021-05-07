package com.path_studio.moviecatalogue.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowEntity(
        val overview: String?,
        val originalName: String?,
        val name: String?,
        val posterPath: String?,
        val backdropPath: String?,
        val firstAirDate: String?,
        val voteAverage: Double?,
        val id: Long
): Parcelable