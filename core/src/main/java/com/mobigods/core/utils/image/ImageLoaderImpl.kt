package com.mobigods.core.utils.image

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.mobigods.core.R
import javax.inject.Inject

class ImageLoaderImpl @Inject constructor(private val context: Context): ImageLoader {

    override fun loadImage(imageView: ImageView, url: String, errorRes: Int) {
        Glide.with(context).load(url).error(errorRes).into(imageView)
    }
}