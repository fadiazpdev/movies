package com.fadiazp.movies.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fadiazp.movies.R
import com.fadiazp.movies.network.Movie
import com.fadiazp.movies.presentation.list.MoviesAdapter.MoviesViewHolder

class MoviesAdapter : RecyclerView.Adapter<MoviesViewHolder>() {
    var data = listOf<Movie>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =
            layoutInflater.inflate(R.layout.layout_movie_item_view, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val item = data[position]
        holder.titleTextView.text = item.title
    }

    override fun getItemCount() = data.size

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    }
}
