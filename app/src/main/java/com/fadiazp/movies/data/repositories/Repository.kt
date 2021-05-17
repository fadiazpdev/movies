package com.fadiazp.movies.data.repositories

import com.fadiazp.movies.domain.DomainMovie

interface Repository {
    suspend fun getMovies(genre: Int): List<DomainMovie>

    suspend fun getMovieById(movieId: Int): DomainMovie
}