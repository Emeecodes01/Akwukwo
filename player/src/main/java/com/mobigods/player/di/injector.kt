package com.mobigods.player.di

import com.mobigods.core.base.BaseFragment
import com.mobigods.player.ui.PlayerFragment


fun BaseFragment<*>.getPlayerComponent(): PlayerComponent =
    DaggerPlayerComponent.builder().build()

internal fun <F : BaseFragment<*>> F.inject() {
    when (this) {
        is PlayerFragment -> getPlayerComponent().inject(this)
    }
}