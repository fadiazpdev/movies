package com.fadiazp.movies.domain

data class DomainMovie(
    val id: Int,
    val backdropPath: String,
    val language: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: String,
    val voteCount: String
)