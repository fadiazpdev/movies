package com.fadiazp.movies.presentation.detail.di

import com.fadiazp.movies.data.repositories.MoviesRepository
import com.fadiazp.movies.interactors.GetMovieByIdInteractor
import com.fadiazp.movies.interactors.GetMoviesInteractor
import com.fadiazp.movies.presentation.detail.DetailViewModel
import dagger.Module
import dagger.Provides

@Module
class DetailFragmentModule {

    @Provides
    fun detailDetailViewModelProvider(
        interactor: GetMovieByIdInteractor
    ) = DetailViewModel(interactor)

    @Provides
    fun getMoviesInteractorProvider(
        repository: MoviesRepository
    ) = GetMovieByIdInteractor(repository)
}
