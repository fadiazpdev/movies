package com.fadiazp.movies.di

import android.app.Application
import androidx.room.Room
import com.fadiazp.movies.R
import com.fadiazp.movies.data.sources.LocalDataSource
import com.fadiazp.movies.data.sources.RemoteDataSource
import com.fadiazp.movies.sources.database.MovieDB
import com.fadiazp.movies.sources.database.RoomDataSource
import com.fadiazp.movies.sources.network.Network
import com.fadiazp.movies.sources.network.RetrofitDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    @Named("apiKey")
    fun apiKeyProvider(app: Application): String = app.getString(R.string.api_key)

    @Provides
    fun remoteDataSourceProvider(
        network: Network,
        @Named("apiKey") apiKey: String
    ): RemoteDataSource = RetrofitDataSource(network, apiKey)

    @Provides
    @Singleton
    fun dbProvider(app: Application) = Room.databaseBuilder(
        app,
        MovieDB::class.java,
        "movieDB"
    ).build()

    @Provides
    fun localDataSourceProvider(
        db: MovieDB
    ): LocalDataSource = RoomDataSource(db)
}
