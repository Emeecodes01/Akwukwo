package com.mobigods.core.di.component

import android.content.Context
import com.mobigods.core.di.module.UtilsModule
import com.mobigods.core.utils.image.ImageLoader
import com.mobigods.domain.thread.ExecutionThread
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ UtilsModule::class] )
interface CoreComponent {

    fun getContext(): Context
    fun threadExecutor(): ExecutionThread
    fun imageLoader(): ImageLoader


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun addContext(context: Context): Builder

        fun build(): CoreComponent
    }

}