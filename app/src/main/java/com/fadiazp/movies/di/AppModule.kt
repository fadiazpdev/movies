package com.fadiazp.movies.di

import android.app.Application
import com.fadiazp.movies.R
import com.fadiazp.movies.data.sources.RemoteDataSource
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
}