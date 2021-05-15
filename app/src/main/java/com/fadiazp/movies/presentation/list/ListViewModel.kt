package com.fadiazp.movies.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fadiazp.movies.domain.DomainMovie
import com.fadiazp.movies.interactors.GetMoviesInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val getMovies: GetMoviesInteractor
) : ViewModel() {

    private val _movies = MutableLiveData<List<DomainMovie>>()
    val movies: LiveData<List<DomainMovie>>
        get() = _movies

    fun getMovies(genre: Int) {
        viewModelScope.launch {
            _movies.value = getMovies.invoke(genre)
        }
    }
}
