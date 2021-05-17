package com.fadiazp.movies.data.repositories

import com.fadiazp.movies.data.sources.FakeLocalDataSource
import com.fadiazp.movies.data.sources.FakeRemoteDataSource
import com.fadiazp.movies.remoteMoviesList
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MoviesRepositoryTest {

    companion object {
        const val animationMovies = 16
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

        val result = repository.getMovies(animationMovies)

        assertEquals(
            remoteMoviesList[0].id,
            fakeLocal.localMoviesList[0].id
        )
        assertEquals(
            remoteMoviesList[0].id,
            result[0].id
        )
        assertEquals(
            result[0].posterPath,
            "$posterPathUrl${remoteMoviesList[0].posterPath}"
        )
    }

    @Test
    fun testingGetMovieById() = runBlocking {
        repository.getMovies(animationMovies)

        val result = repository.getMovieById(idMovieTest)

        assertEquals(
            result.id,
            idMovieTest
        )
        assertEquals(
            result.backdropPath,
            "$posterPathUrl${remoteMoviesList[0].backdropPath}"
        )
    }
}
