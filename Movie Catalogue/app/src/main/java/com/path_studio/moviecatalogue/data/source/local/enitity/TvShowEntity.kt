package com.path_studio.moviecatalogue.data.source.local.enitity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tv_show_entities")
data class TvShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowId: Long,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "overview")
    var overview: String? = null,

    @ColumnInfo(name = "posterPath")
    var posterPath: String? = null,

    @ColumnInfo(name = "backdropPath")
    var backdropPath: String? = null,

    @ColumnInfo(name = "voteAverage")
    var voteAverage: Double?,

    @ColumnInfo(name = "firstAirDate")
    val firstAirDate: String?,

    /*@ColumnInfo(name = "genres")
    val genres:ArrayList<String>? = ArrayList(),*/

    @ColumnInfo(name = "runtime")
    val runtime: Int? = 0,

    @ColumnInfo(name = "releaseDate")
    val releaseDate: String? = "",

    @NonNull
    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false
){
    @Embedded
    var contentEntity: ContentEntity? = null
}
