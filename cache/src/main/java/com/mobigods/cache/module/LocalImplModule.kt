package com.mobigods.cache.module

import com.mobigods.cache.impl.AkwukwoRecentLessonsLocalRepositoryImpl
import com.mobigods.cache.impl.AkwukwoSubjectsLocalRepositoryImpl
import com.mobigods.cache.preference.AkwukwoPreferenceManager
import com.mobigods.cache.preference.IPreferenceManager
import com.mobigods.domain.repository.local.AkwukwoRecentLessonsLocalRepository
import com.mobigods.domain.repository.local.AkwukwoSubjectsLocalRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [LocalDaoModule::class])
abstract class LocalImplModule {

    @Binds
    @Singleton
    abstract fun bindPreferenceManager(
        impl: AkwukwoPreferenceManager
    ): IPreferenceManager


    @Binds
    @Singleton
    abstract fun bind (
        impl: AkwukwoSubjectsLocalRepositoryImpl
    ): AkwukwoSubjectsLocalRepository


    @Binds
    @Singleton
    abstract fun bindRecentLessonImpl (
        impl: AkwukwoRecentLessonsLocalRepositoryImpl
    ): AkwukwoRecentLessonsLocalRepository
}