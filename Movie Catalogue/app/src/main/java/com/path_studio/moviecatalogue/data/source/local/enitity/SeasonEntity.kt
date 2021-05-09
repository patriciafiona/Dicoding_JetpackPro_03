package com.path_studio.moviecatalogue.data.source.local.enitity

import androidx.annotation.NonNull
import androidx.room.*

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
    var seasonId: Int?,

    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowId: String,

    @ColumnInfo(name = "name")
    var name: String?,

    @ColumnInfo(name = "overview")
    var overview: String?,

    @ColumnInfo(name = "airDate")
    var airDate: String?,

    @ColumnInfo(name = "seasonNumber")
    var seasonNumber: Int?,

    @ColumnInfo(name = "episodeCount")
    var episodeCount: Int?,

    @ColumnInfo(name = "posterPath")
    var posterPath: String?
)
