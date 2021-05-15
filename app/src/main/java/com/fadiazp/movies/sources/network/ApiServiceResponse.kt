package com.fadiazp.movies.sources.network

import com.google.gson.annotations.SerializedName

data class ApiServiceResponse(
    @SerializedName("page")val page: Int,
    @SerializedName("results") val results: List<NetworkMovie>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)

data class NetworkMovie(
    @SerializedName("id")val id: Int,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("genre_ids") val genreIds: List<Int>,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview")val overview: String,
    @SerializedName("popularity")val popularity: Double,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("title")val title: String,
    @SerializedName("video")val video: Boolean,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Int
)