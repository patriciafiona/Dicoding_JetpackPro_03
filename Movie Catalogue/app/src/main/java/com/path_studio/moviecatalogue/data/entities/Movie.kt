package com.path_studio.moviecatalogue.data.entities

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    var movieId: Long = 0,
    var title: String = "",
    var overview: String? = null,
    var posterPath: String? = null,
    var backdropPath: String? = null,
    var releaseDate: String? = null,
    var voteAverage: Double = 0.0,
    val genres: String? = null,
    val runtime: Int? = 0,
    var favorite: Boolean = false
): Parcelable
