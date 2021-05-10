package com.path_studio.moviecatalogue.data.source.local.enitity

import androidx.room.ColumnInfo

data class ContentEntity(
    @ColumnInfo(name = "content")
    var content: String?
)
