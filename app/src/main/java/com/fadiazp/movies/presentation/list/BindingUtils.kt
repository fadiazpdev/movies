package com.fadiazp.movies.presentation.list

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("url")
fun ImageView.setUrl(posterPath: String) {
    Glide.with(context).load(posterPath).into(this)
}
