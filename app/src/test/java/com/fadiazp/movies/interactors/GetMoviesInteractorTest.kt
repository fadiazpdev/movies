package com.fadiazp.movies.interactors

import com.fadiazp.movies.data.repositories.MoviesRepository
import com.fadiazp.movies.domainMoviesList
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GetMoviesInteractorTest {

    companion object {
        const val animationMovies = 16
    }

    @Mock
    lateinit var repository: MoviesRepository

    lateinit var interactor: GetMoviesInteractor

    @Before
    fun setUp() {
        interactor = GetMoviesInteractor(repository)
    }

    @Test
    fun testGetMoviesInteractor() = runBlocking {

        Mockito.`when`(repository.getMovies(animationMovies))
            .thenReturn(domainMoviesList)

        val result = interactor.invoke(animationMovies)

        assertEquals(result, domainMoviesList)
    }
}
