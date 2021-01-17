package com.mobigods.player.utils

import android.content.Context
import androidx.core.app.ComponentActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer

fun Fragment.exoplayer(playerBuilder: SimpleExoPlayer.Builder.() -> Unit): SimpleExoPlayer {
    return SimpleExoPlayer.Builder(requireContext()).apply(playerBuilder).build()
}


fun mediaitem(mediaItemBuilder: MediaItem.Builder.() -> Unit): MediaItem {
    return MediaItem.Builder()
        .apply(mediaItemBuilder).build()
}

//fun Fragment.exoplayer(exoBuilder: ExoBuilder.() -> Unit) {
//    ExoBuilder().apply(exoBuilder)
//}
//
//class ExoBuilder(private val context: Context) {
//    var exoplayer: SimpleExoPlayer? = null
//    var mediaItem: MediaItem? = null
//
//
//    fun createExoplayer(): SimpleExoPlayer {
//
//    }
//}