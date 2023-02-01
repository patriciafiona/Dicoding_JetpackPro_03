package com.path_studio.moviecatalogue.data.source.local.enitity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(tableName = "season_entities",
    primaryKeys = ["tvShowId", "seasonId"],
    foreignKeys = [ForeignKey(entity = TvShowEntity::class,
        parentColumns = ["tvShowId"],
        childColumns = ["tvShowId"])],
    indices = [Index(value = ["seasonId"]),
        Index(value = ["tvShowId"])])

data class SeasonEntity(
    @NonNull
    @ColumnInfo(name = "seasonId")
    var seasonId: String = "",

    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowId: String = "",

    @ColumnInfo(name = "name")
    var name: String? ="",

    @ColumnInfo(name = "overview")
    var overview: String? ="No description",

    @ColumnInfo(name = "airDate")
    var airDate: String? ="",

    @ColumnInfo(name = "seasonNumber")
    var seasonNumber: Int? = 0,

    @ColumnInfo(name = "episodeCount")
    var episodeCount: Int? = 0,

    @ColumnInfo(name = "posterPath")
    var posterPath: String? = "",

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false
)
