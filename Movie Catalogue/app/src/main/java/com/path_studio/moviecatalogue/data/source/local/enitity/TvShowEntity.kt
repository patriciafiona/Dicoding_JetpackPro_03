package com.path_studio.moviecatalogue.data.source.local.enitity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tv_show_entities")
data class TvShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowId: Long = 0L,

    @ColumnInfo(name = "name")
    var name: String = "Unknown Name",

    @ColumnInfo(name = "overview")
    var overview: String? = null,

    @ColumnInfo(name = "posterPath")
    var posterPath: String? = null,

    @ColumnInfo(name = "backdropPath")
    var backdropPath: String? = null,

    @ColumnInfo(name = "voteAverage")
    var voteAverage: Double? = 0.0,

    @ColumnInfo(name = "firstAirDate")
    val firstAirDate: String? = null,

    @ColumnInfo(name = "genres")
    val genres: String? = null,

    @ColumnInfo(name = "runtime")
    val runtime: Int? = 0,

    @NonNull
    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false
)
