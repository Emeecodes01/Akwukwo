package com.mobigods.core.di.module

import com.mobigods.core.utils.thread.ThreadExecutorImpl
import com.mobigods.core.utils.image.ImageLoader
import com.mobigods.core.utils.image.ImageLoaderImpl
import com.mobigods.domain.thread.ExecutionThread
import dagger.Binds
import dagger.Module

@Module
abstract class UtilsModule {

    @Binds
    abstract fun provideThreadExecutor(
        impl: ThreadExecutorImpl
    ): ExecutionThread


    @Binds
    abstract fun provideImageLoader(
        impl: ImageLoaderImpl
    ): ImageLoader

}