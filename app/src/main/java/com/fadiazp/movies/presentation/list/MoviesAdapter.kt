package com.fadiazp.movies.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fadiazp.movies.databinding.LayoutMovieItemViewBinding
import com.fadiazp.movies.domain.DomainMovie
import com.fadiazp.movies.presentation.list.MoviesAdapter.MoviesViewHolder

class MoviesAdapter(
    private val listener: MoviesListener
) : ListAdapter<DomainMovie, MoviesViewHolder>(MoviesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item,listener)
    }

    class MoviesViewHolder private constructor(
        private val binding: LayoutMovieItemViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DomainMovie, listener: MoviesListener) {
            binding.movie = item
            binding.click = listener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MoviesViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutMovieItemViewBinding.inflate(layoutInflater, parent, false)
                return MoviesViewHolder(binding)
            }
        }
    }
}

class MoviesDiffCallback : DiffUtil.ItemCallback<DomainMovie>() {
    override fun areItemsTheSame(oldItem: DomainMovie, newItem: DomainMovie) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: DomainMovie, newItem: DomainMovie) = oldItem == newItem
}

class MoviesListener(val click: (id: Int) -> Unit) {
    fun onClick(movie: DomainMovie) = click(movie.id)
}
