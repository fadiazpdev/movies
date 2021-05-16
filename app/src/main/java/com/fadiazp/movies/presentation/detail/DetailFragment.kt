package com.fadiazp.movies.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.fadiazp.movies.R
import com.fadiazp.movies.databinding.DetailFragmentBinding
import com.fadiazp.movies.presentation.common.app
import com.fadiazp.movies.presentation.common.getViewModel
import com.fadiazp.movies.presentation.detail.di.DetailFragmentComponent
import com.fadiazp.movies.presentation.detail.di.DetailFragmentModule

class DetailFragment : Fragment() {

    private var binding: DetailFragmentBinding? = null
    private lateinit var component: DetailFragmentComponent
    private val viewModel by lazy { getViewModel { component.viewModel } }
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.detail_fragment, container, false
        )
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        component = app.component.plus(DetailFragmentModule())

        viewModel.getMovieById(args.idMovie)

        binding?.apply {
            lifecycleOwner = this@DetailFragment
            vm = viewModel
        }
    }
}