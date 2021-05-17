package com.fadiazp.movies.data.repositories

import com.fadiazp.movies.data.sources.LocalDataSource
import com.fadiazp.movies.data.sources.RemoteDataSource
import com.fadiazp.movies.domain.DomainMovie
import com.fadiazp.movies.sources.toDomain
import com.fadiazp.movies.sources.toLocal
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : Repository {

    override suspend fun getMovies(genre: Int): List<DomainMovie> {
        val moviesFromNetwork = remoteDataSource.getMovies(genre)
        localDataSource.insertMovies(moviesFromNetwork.toLocal())
        return moviesFromNetwork.toDomain()
    }

    override suspend fun getMovieById(movieId: Int): DomainMovie {
        return localDataSource.getMovieById(movieId).toDomain()
    }
}
