package com.fadiazp.movies.interactors

import com.fadiazp.movies.data.repositories.MoviesRepository
import com.fadiazp.movies.domain.DomainMovie
import javax.inject.Inject

class GetMoviesInteractor @Inject constructor(
    private val repository: MoviesRepository
) {
    suspend fun invoke(genre: Int): List<DomainMovie> = repository.getMovies(genre)
}