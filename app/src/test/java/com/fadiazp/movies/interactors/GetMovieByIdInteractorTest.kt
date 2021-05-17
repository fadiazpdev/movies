package com.fadiazp.movies.interactors

import com.fadiazp.movies.data.repositories.MoviesRepository
import com.fadiazp.movies.domainMovie
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
class GetMovieByIdInteractorTest {

    companion object {
        const val idMovieTest = 811367
    }

    @Mock
    lateinit var repository: MoviesRepository

    lateinit var interactor: GetMovieByIdInteractor

    @Before
    fun setUp() {
        interactor = GetMovieByIdInteractor(repository)
    }

    @Test
    fun testGetMovieByIdInteractor() = runBlocking {

        Mockito.`when`(repository.getMovieById(idMovieTest)).thenReturn(domainMovie)

        val result = interactor.invoke(idMovieTest)

        assertEquals(result, domainMovie)
    }
}
