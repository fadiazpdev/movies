package com.fadiazp.movies.data.sources

import com.fadiazp.movies.sources.network.NetworkMovie

interface RemoteDataSource {
    suspend fun getMovies(genre: Int): List<NetworkMovie>
}