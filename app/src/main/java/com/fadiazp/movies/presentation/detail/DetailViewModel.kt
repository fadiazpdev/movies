package com.fadiazp.movies.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fadiazp.movies.domain.DomainMovie
import com.fadiazp.movies.interactors.GetMovieByIdInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val getMovie: GetMovieByIdInteractor
) : ViewModel() {

    private val _movie = MutableLiveData<DomainMovie>()
    val movie: LiveData<DomainMovie>
        get() = _movie

    fun getMovieById(idMovie: Int) {
        viewModelScope.launch {
            _movie.value = getMovie.invoke(idMovie)
        }
    }
}
