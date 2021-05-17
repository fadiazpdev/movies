package com.fadiazp.movies.data.sources

import com.fadiazp.movies.sources.network.NetworkMovie

class FakeRemoteDataSource : RemoteDataSource {

    val remoteMoviesList = listOf(
        NetworkMovie(
            id = 811367,
            backdropPath = "/n2y7T8wJVjJ8yLhQXQgNCpsC3ga.jpg",
            genreIds = listOf(10751, 16, 35),
            originalLanguage = "en",
            originalTitle = "22 vs. Earth",
            overview = "Set before the events of ‘Soul’, 22 refuses to go to Earth, enlisting a gang of 5 new souls in attempt of rebellion. However, 22’s subversive plot leads to a surprising revelation about the meaning of life.",
            popularity = 1658.194,
            posterPath = "/32vLDKSzcCMh55zqqaSqqUA8naz.jpg",
            releaseDate = "2021-04-30",
            title = "22 vs. Earth",
            video = false,
            voteAverage = 7.2,
            voteCount = 67
        ),
        NetworkMovie(
            id = 635302,
            backdropPath = "/xPpXYnCWfjkt3zzE0dpCNME1pXF.jpg",
            genreIds = listOf(16, 28, 12, 14, 18),
            originalLanguage = "ja",
            originalTitle = "劇場版「鬼滅の刃」無限列車編",
            overview = "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
            popularity = 1658.194,
            posterPath = "/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
            releaseDate = "2020-10-16",
            title = "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train",
            video = false,
            voteAverage = 8.4,
            voteCount = 938
        )
    )

    override suspend fun getMovies(genre: Int) = remoteMoviesList.filter { it.genreIds.contains(genre) }
}