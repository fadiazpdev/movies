package com.fadiazp.movies.di

import android.app.Application
import com.fadiazp.movies.presentation.detail.di.DetailFragmentComponent
import com.fadiazp.movies.presentation.detail.di.DetailFragmentModule
import com.fadiazp.movies.presentation.list.di.ListFragmentComponent
import com.fadiazp.movies.presentation.list.di.ListFragmentModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    fun plus(module: ListFragmentModule): ListFragmentComponent
    fun plus(module: DetailFragmentModule): DetailFragmentComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppComponent
    }
}