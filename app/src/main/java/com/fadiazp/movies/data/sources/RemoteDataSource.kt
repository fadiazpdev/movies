package com.fadiazp.movies.data.sources

import com.fadiazp.movies.network.Movie

interface RemoteDataSource {
    suspend fun getMovies(genre: Int): List<Movie>
}