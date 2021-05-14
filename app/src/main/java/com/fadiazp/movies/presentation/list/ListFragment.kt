package com.fadiazp.movies.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.fadiazp.movies.R
import com.fadiazp.movies.databinding.ListFragmentBinding
import com.fadiazp.movies.presentation.common.app
import com.fadiazp.movies.presentation.common.getViewModel
import com.fadiazp.movies.presentation.list.di.ListFragmentComponent
import com.fadiazp.movies.presentation.list.di.ListFragmentModule

class ListFragment : Fragment() {

    private lateinit var component: ListFragmentComponent
    private val viewModel by lazy { getViewModel { component.viewModel } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ListFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.list_fragment, container, false)

        component = app.component.plus(ListFragmentModule())

        viewModel.getMovies(16)

        val adapter = MoviesAdapter()
        binding.moviesRecyclerView.adapter = adapter


        viewModel.movies.observe(viewLifecycleOwner, {
            it?.let {
                adapter.data = it
            }
        })

        return binding.root
    }
}