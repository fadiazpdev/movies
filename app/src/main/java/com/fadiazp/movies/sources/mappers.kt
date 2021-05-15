package com.fadiazp.movies.sources

import com.fadiazp.movies.domain.DomainMovie
import com.fadiazp.movies.sources.network.NetworkMovie

fun List<NetworkMovie>.toDomain(): List<DomainMovie> {
    return this.map {
        DomainMovie(
            id = it.id,
            backdropPath = it.backdropPath,
            genreIds = it.genreIds,
            originalLanguage = it.originalLanguage,
            originalTitle = it.originalTitle,
            overview = it.overview,
            popularity = it.popularity,
            posterPath = "https://image.tmdb.org/t/p/w185${it.posterPath}",
            releaseDate = it.releaseDate,
            title = it.title,
            video = it.video,
            voteAverage = it.voteAverage,
            voteCount = it.voteCount
        )
    }
}