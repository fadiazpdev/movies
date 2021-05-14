package com.fadiazp.movies

import android.app.Application
import com.fadiazp.movies.di.AppComponent
import com.fadiazp.movies.di.DaggerAppComponent

class App :Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = initAppComponent()
    }

    private fun initAppComponent() = DaggerAppComponent.factory().create(this)
}