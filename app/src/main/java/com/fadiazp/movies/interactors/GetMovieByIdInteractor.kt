package com.fadiazp.movies.interactors

import com.fadiazp.movies.data.repositories.Repository
import com.fadiazp.movies.domain.DomainMovie
import javax.inject.Inject

class GetMovieByIdInteractor @Inject constructor(
    private val repository: Repository
) {
    suspend fun invoke(idMovie: Int): DomainMovie {
        return repository.getMovieById(idMovie)
    }
}
