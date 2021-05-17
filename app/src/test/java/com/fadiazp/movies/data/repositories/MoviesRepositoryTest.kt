package com.fadiazp.movies.data.repositories

import com.fadiazp.movies.data.sources.FakeLocalDataSource
import com.fadiazp.movies.data.sources.FakeRemoteDataSource
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MoviesRepositoryTest {

    companion object {
        const val adventureMovies = 16
        const val posterPathUrl = "https://image.tmdb.org/t/p/w185"
        const val idMovieTest = 811367
    }

    private lateinit var repository: Repository
    private val fakeLocal by lazy { FakeLocalDataSource() }
    private val fakeRemote by lazy { FakeRemoteDataSource() }

    @Before
    fun setUp() {
        repository = MoviesRepository(
            fakeLocal,
            fakeRemote
        )
    }

    @Test
    fun testingGetMoviesMethod() = runBlocking {

        val result = repository.getMovies(adventureMovies)

        assertEquals(
            fakeRemote.remoteMoviesList[0].id,
            fakeLocal.localMoviesList[0].id
        )
        assertEquals(
            fakeRemote.remoteMoviesList[0].id,
            result[0].id
        )
        assertEquals(
            result[0].posterPath,
            "$posterPathUrl${fakeRemote.remoteMoviesList[0].posterPath}"
        )
    }

    @Test
    fun testingGetMovieById() = runBlocking {
        repository.getMovies(adventureMovies)

        val result = repository.getMovieById(idMovieTest)

        assertEquals(
            result.id,
            idMovieTest
        )
        assertEquals(
            result.backdropPath,
            "$posterPathUrl${fakeRemote.remoteMoviesList[0].backdropPath}"
        )
    }
}
