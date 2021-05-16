package com.fadiazp.movies.di

import com.fadiazp.movies.data.repositories.MoviesRepository
import com.fadiazp.movies.data.sources.LocalDataSource
import com.fadiazp.movies.data.sources.RemoteDataSource
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun moviesRepositoryProvider(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ) = MoviesRepository(localDataSource, remoteDataSource)
}
