package com.mobigods.core.utils.image

import android.widget.ImageView
import com.mobigods.core.R

interface ImageLoader {
    fun loadImage(imageView: ImageView, url: String, errorRes: Int = R.drawable.ic_physics)
}