package com.fadiazp.movies.presentation.list.di

import com.fadiazp.movies.data.repositories.Repository
import com.fadiazp.movies.interactors.GetMoviesInteractor
import com.fadiazp.movies.presentation.list.ListViewModel
import dagger.Module
import dagger.Provides

@Module
class ListFragmentModule {

    @Provides
    fun listViewModelProvider(
        interactor: GetMoviesInteractor
    ) = ListViewModel(interactor)

    @Provides
    fun getMoviesInteractorProvider(
        repository: Repository
    ) = GetMoviesInteractor(repository)
}
