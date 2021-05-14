package com.fadiazp.movies.di

import android.app.Application
import com.fadiazp.movies.R
import com.fadiazp.movies.network.Network
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    @Named("url")
    fun baseUrlProvider(
        app: Application
    ) = app.getString(R.string.url)

    @Singleton
    @Provides
    fun movieDBProvider(
        @Named("url") url: String
    ) = Network(url)
}