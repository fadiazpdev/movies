package com.fadiazp.movies.data.sources

import com.fadiazp.movies.sources.database.LocalMovie

class FakeLocalDataSource : LocalDataSource {

    val localMoviesList = mutableListOf<LocalMovie>()

    override suspend fun insertMovies(movies: List<LocalMovie>) {
        localMoviesList.addAll(movies)
    }

    override suspend fun getMovieById(movieId: Int): LocalMovie {
        return localMoviesList.first { it.id == movieId }
    }
}