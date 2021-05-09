package com.path_studio.moviecatalogue.data.source.local.enitity

import androidx.room.Embedded
import androidx.room.Relation

data class TvShowWithSeason (
    @Embedded
    var mTvShow: TvShowEntity,

    @Relation(parentColumn = "tvShowId", entityColumn = "tvShowId")
    var mSeason: List<SeasonEntity>
)