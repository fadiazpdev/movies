package com.fadiazp.movies.presentation.detail.di

import com.fadiazp.movies.presentation.detail.DetailViewModel
import dagger.Subcomponent

@Subcomponent(modules = [DetailFragmentModule::class])
interface DetailFragmentComponent {
    val detailViewModel: DetailViewModel
}