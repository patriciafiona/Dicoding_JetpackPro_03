package com.path_studio.moviecatalogue.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowSeasonEntity(
        var air_date: String?,
        var episode_count: Int?,
        var id: Int?,
        var name: String?,
        var overview: String?,
        var poster_path: String?,
        var season_number: Int?
): Parcelable
