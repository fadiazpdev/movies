package com.fadiazp.movies.data.repositories

import com.fadiazp.movies.data.sources.RemoteDataSource
import com.fadiazp.movies.domain.DomainMovie
import com.fadiazp.movies.sources.toDomain
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getMovies(genre: Int): List<DomainMovie> {
        return remoteDataSource.getMovies(genre).toDomain()
    }
}
