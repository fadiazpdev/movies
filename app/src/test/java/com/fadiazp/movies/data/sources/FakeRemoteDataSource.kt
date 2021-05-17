package com.fadiazp.movies.data.sources

import com.fadiazp.movies.remoteMoviesList

class FakeRemoteDataSource : RemoteDataSource {

    override suspend fun getMovies(genre: Int) =
        remoteMoviesList.filter { it.genreIds.contains(genre) }
}
