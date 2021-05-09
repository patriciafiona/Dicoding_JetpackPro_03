package com.path_studio.moviecatalogue.data.source.local.enitity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genre_entities")
data class GenreEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "genreId")
    var genreId: Long,

    @ColumnInfo(name = "name")
    var name: String
)
