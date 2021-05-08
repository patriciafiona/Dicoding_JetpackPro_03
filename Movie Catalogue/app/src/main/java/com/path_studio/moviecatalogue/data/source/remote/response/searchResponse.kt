package com.path_studio.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SearchResponse(

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("results")
	val results: List<SearchResultsItem?>? = null,

	@field:SerializedName("total_results")
	val totalResults: Int? = null
)

data class SearchResultsItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("overview")
	val overview: String? = null,

	@field:SerializedName("poster_path")
	val posterPath: String? = null,

	@field:SerializedName("backdrop_path")
	val backdropPath: String? = null,

	@field:SerializedName("media_type")
	val mediaType: String,

	@field:SerializedName("release_date")
	val releaseDate: String? = null,

	@field:SerializedName("first_air_date")
	val firstAirDate: String? = null,

	@field:SerializedName("vote_average")
	val voteAverage: Double? = null,

)
