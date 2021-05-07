package com.path_studio.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @field:SerializedName("id")
    val id: Long,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("backdrop_path")
    val backdropPath: String,

    @field:SerializedName("media_type")
    val mediaType: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("vote_average")
    val voteAverage: Double,

    @field:SerializedName("release_or_air_date")
    val releaseOrAirDate: String
)
