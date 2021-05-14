package com.fadiazp.movies.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("discover/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("with_genres") genre: Int
    ): ApiServiceResponse
}