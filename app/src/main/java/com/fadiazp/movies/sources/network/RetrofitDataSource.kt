package com.fadiazp.movies.sources.network

import com.fadiazp.movies.data.sources.RemoteDataSource
import javax.inject.Inject

class RetrofitDataSource @Inject constructor(
    private val network: Network, private val apiKey: String
) : RemoteDataSource {

    override suspend fun getMovies(genre: Int): List<NetworkMovie> {
        return network.service.getMovies(apiKey, genre).results
    }
}
