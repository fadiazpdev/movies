package com.fadiazp.movies.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fadiazp.movies.data.sources.RemoteDataSource
import com.fadiazp.movies.network.Movie
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    fun getMovies(genre: Int) {
        viewModelScope.launch {
           _movies.value = remoteDataSource.getMovies(genre)
        }
    }
}