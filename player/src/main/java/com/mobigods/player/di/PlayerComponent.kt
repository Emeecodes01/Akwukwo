package com.mobigods.player.di

import android.content.Context
import com.mobigods.cache.module.LocalImplModule
import com.mobigods.core.di.module.UtilsModule
import com.mobigods.player.ui.PlayerFragment
import com.mobigods.presentation.di.modules.ViewModelModule
import com.mobigods.remote.modules.RemoteImplModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [UtilsModule::class, ViewModelModule::class, LocalImplModule::class, RemoteImplModule::class]
)
@Singleton
interface PlayerComponent {
    fun inject(fragment: PlayerFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun addContext(context: Context): Builder

        fun build(): PlayerComponent
    }
}