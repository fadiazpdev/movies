package com.fadiazp.movies.presentation.detail.di

import com.fadiazp.movies.presentation.detail.DetailViewModel
import dagger.Module
import dagger.Provides

@Module
class DetailFragmentModule {

    @Provides
    fun detailDetailViewModelProvider() = DetailViewModel()
}