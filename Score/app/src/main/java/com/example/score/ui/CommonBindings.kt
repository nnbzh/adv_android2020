package com.example.score.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.score.R
import com.squareup.picasso.Picasso

@BindingAdapter("android:source")
fun loadImage(imageView: ImageView, url: String) {
    Picasso.get().load(url).into(imageView)
}