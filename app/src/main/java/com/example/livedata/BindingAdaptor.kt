package com.example.livedata

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter(value = ["app:imageUrl","appContext"], requireAll = true)
fun image(view:ImageView,url: String?, context: Context){
    Glide
        .with(context)
        .load(url)
        .centerCrop()
        .placeholder(R.mipmap.ic_launcher)
        .into(view)
}