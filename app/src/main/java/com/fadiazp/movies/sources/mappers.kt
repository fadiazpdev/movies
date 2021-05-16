package com.fadiazp.movies.sources

import com.fadiazp.movies.domain.DomainMovie
import com.fadiazp.movies.sources.database.LocalMovie
import com.fadiazp.movies.sources.network.NetworkMovie

fun List<NetworkMovie>.toDomain(): List<DomainMovie> {
    return this.map {
        DomainMovie(
            id = it.id,
            backdropPath = it.backdropPath,
            overview = it.overview,
            language = it.originalLanguage,
            posterPath = "https://image.tmdb.org/t/p/w185${it.posterPath}",
            releaseDate = it.releaseDate,
            title = it.title,
            voteAverage = it.voteAverage.toString(),
            voteCount = it.voteCount.toString()
        )
    }
}

fun List<NetworkMovie>.toLocal(): List<LocalMovie> {
    return this.map {
        LocalMovie(
            id = it.id,
            backdropPath = "https://image.tmdb.org/t/p/w185${it.backdropPath}",
            originalLanguage = it.originalLanguage,
            overview = it.overview,
            posterPath = "https://image.tmdb.org/t/p/w185${it.posterPath}",
            releaseDate = it.releaseDate,
            title = it.title,
            voteAverage = it.voteAverage.toString(),
            voteCount = it.voteCount.toString()
        )
    }
}

fun LocalMovie.toDomain(): DomainMovie {
    return DomainMovie(
        id = this.id,
        backdropPath = this.backdropPath,
        language = this.originalLanguage,
        overview = this.overview,
        posterPath = this.posterPath,
        releaseDate = this.releaseDate,
        title = this.title,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount
    )
}