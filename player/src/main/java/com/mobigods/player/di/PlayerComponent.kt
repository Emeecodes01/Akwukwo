package com.mobigods.player.di

import com.mobigods.cache.module.LocalImplModule
import com.mobigods.core.di.module.UtilsModule
import com.mobigods.player.ui.PlayerFragment
import com.mobigods.presentation.di.modules.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [UtilsModule::class, ViewModelModule::class, LocalImplModule::class]
)
@Singleton
interface PlayerComponent {
    fun inject(fragment: PlayerFragment)
}