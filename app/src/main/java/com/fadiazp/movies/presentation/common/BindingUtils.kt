package com.fadiazp.movies.presentation.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("url")
fun ImageView.setUrl(url: String?) {
    url?.let {
        Glide.with(context).load(it).into(this)
    }
}
