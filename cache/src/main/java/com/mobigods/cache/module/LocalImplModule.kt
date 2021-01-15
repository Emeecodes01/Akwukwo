package com.mobigods.cache.module

import com.mobigods.cache.impl.AkwukwoSubjectsLocalRepositoryImpl
import com.mobigods.domain.repository.local.AkwukwoSubjectsLocalRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [LocalDaoModule::class])
abstract class LocalImplModule {

    @Binds
    @Singleton
    abstract fun bind (
        impl: AkwukwoSubjectsLocalRepositoryImpl
    ): AkwukwoSubjectsLocalRepository


}