package com.mobigods.player.di

import android.content.Context
import com.mobigods.core.base.BaseFragment
import com.mobigods.player.ui.PlayerFragment


fun getPlayerComponent(context: Context): PlayerComponent =
    DaggerPlayerComponent.builder().addContext(context).build()

internal fun <F : BaseFragment<*>> F.inject() {
    when (this) {
        is PlayerFragment -> getPlayerComponent(requireContext().applicationContext).inject(this)
    }
}