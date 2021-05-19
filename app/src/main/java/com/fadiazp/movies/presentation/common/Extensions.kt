package com.fadiazp.movies.presentation.common

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.fadiazp.movies.App

/***************************************************************************************
 *    Title: Hacking Architecture Components by using Kotlin
 *    Author: Antonio Leiva
 *    Date: March 2018
 *    Availability: https://antonioleiva.com/architecture-components-kotlin/
 *
 ***************************************************************************************/

@Suppress("UNCHECKED_CAST")
inline fun <reified T : ViewModel> Fragment.getViewModel(crossinline factory: () -> T): T {

    val vmFactory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
    }

    return ViewModelProvider(this, vmFactory).get()
}

val Fragment.app: App
    get() = activity?.applicationContext as App
