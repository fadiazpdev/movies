package com.fadiazp.movies.sources.database

import com.fadiazp.movies.data.sources.LocalDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RoomDataSource @Inject constructor(
    database: MovieDB
) : LocalDataSource {

    private val movieDao = database.movieDao()

    override suspend fun insertMovies(movies: List<LocalMovie>) {
        withContext(Dispatchers.IO) {
            movieDao.insertMovies(movies.map {
                it
            })
        }
    }

    override suspend fun getMovieById(movieId: Int): LocalMovie {
        return withContext(Dispatchers.IO) {
            movieDao.getMovieById(movieId)
        }
    }
}
