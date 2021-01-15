package com.mobigods.core.di.component

import android.content.Context
import com.mobigods.core.di.module.ThreadModule
import com.mobigods.domain.thread.ExecutionThread
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ ThreadModule::class] )
interface CoreComponent {
    fun getContext(): Context
    fun threadExecutor(): ExecutionThread


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun addContext(context: Context): Builder

        fun build(): CoreComponent
    }

}