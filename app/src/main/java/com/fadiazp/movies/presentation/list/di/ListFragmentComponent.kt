package com.fadiazp.movies.presentation.list.di

import com.fadiazp.movies.presentation.list.ListViewModel
import dagger.Subcomponent

@Subcomponent(modules = [ListFragmentModule::class])
interface ListFragmentComponent {
    val viewModel: ListViewModel
}