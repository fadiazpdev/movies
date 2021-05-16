package com.fadiazp.movies.data.sources

import com.fadiazp.movies.sources.database.LocalMovie

interface LocalDataSource {

    suspend fun insertMovies(movies: List<LocalMovie>)

    suspend fun getMovieById(movieId: Int): LocalMovie
}