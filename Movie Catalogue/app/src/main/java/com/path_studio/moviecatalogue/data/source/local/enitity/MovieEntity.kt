package com.path_studio.moviecatalogue.data.source.local.enitity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_entities")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: Long = 0L,

    @ColumnInfo(name = "title")
    var title: String = "Unknown title",

    @ColumnInfo(name = "overview")
    var overview: String? = null,

    @ColumnInfo(name = "posterPath")
    var posterPath: String? = null,

    @ColumnInfo(name = "backdropPath")
    var backdropPath: String? = null,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String? = null,

    @ColumnInfo(name = "voteAverage")
    var voteAverage: Double = 0.0,

    @ColumnInfo(name = "genres")
    val genres: String? = null,

    @ColumnInfo(name = "runtime")
    val runtime: Int? = 0,

    @NonNull
    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false
)
