package com.mobigods.core.di.module

import com.mobigods.core.utils.ThreadExecutorImpl
import com.mobigods.domain.thread.ExecutionThread
import dagger.Binds
import dagger.Module

@Module
abstract class ThreadModule {


    @Binds
    abstract fun provideThreadExecutor(
        impl: ThreadExecutorImpl
    ): ExecutionThread
}