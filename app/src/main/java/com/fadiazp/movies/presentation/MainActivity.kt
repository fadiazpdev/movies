package com.fadiazp.movies.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.fadiazp.movies.R
import com.fadiazp.movies.network.Movie
import com.fadiazp.movies.network.Network
import com.fadiazp.movies.network.RetrofitDataSource
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val apiKey = "13c262ccd9f27666f88ef1ed7ae5ab29"
    private val url = "https://api.themoviedb.org/3/"
    private val animateMovieGenre = 16
    private var networkTest: List<Movie>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val network = Network(url)
        val retrofitDataSource = RetrofitDataSource(network, apiKey)

        lifecycleScope.launch {
            networkTest = retrofitDataSource.getMovies(animateMovieGenre)
        }
    }
}
