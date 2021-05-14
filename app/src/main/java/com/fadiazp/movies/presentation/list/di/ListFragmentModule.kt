package com.fadiazp.movies.presentation.list.di

import com.fadiazp.movies.network.Network
import com.fadiazp.movies.network.RetrofitDataSource
import com.fadiazp.movies.presentation.list.ListViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ListFragmentModule {

    @Provides
    fun listViewModelProvider(retrofitDataSource: RetrofitDataSource) =
        ListViewModel(retrofitDataSource)

    @Provides
    fun remoteDataSourceProvider(
        network: Network,
        @Named("apiKey") apiKey: String
    ) = RetrofitDataSource(network, apiKey)
}