package com.fadiazp.movies.network

import com.fadiazp.movies.data.sources.RemoteDataSource

class RetrofitDataSource(private val network : Network, private val apiKey: String) :
    RemoteDataSource {

    override suspend fun getMovies(genre: Int): List<Movie> {
        return network.service.getMovies(apiKey,genre).results
    }
}