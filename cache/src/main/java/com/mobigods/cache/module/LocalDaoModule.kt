package com.mobigods.cache.module

import com.mobigods.cache.db.AkwukwoDatabase
import com.mobigods.cache.db.dao.LessonDao
import com.mobigods.cache.db.dao.RecentLessonDao
import com.mobigods.cache.db.dao.SubjectDao
import com.mobigods.cache.models.RecentLessonCacheModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataBaseModule::class])
class LocalDaoModule {

    @Provides
    @Singleton
    fun provideSubjectDao(database: AkwukwoDatabase): SubjectDao
    = database.subjectDao()


    @Provides
    @Singleton
    fun provideRecentLessonDao(database: AkwukwoDatabase): RecentLessonDao
            = database.recentLessonDao()

    @Provides
    @Singleton
    fun provideLessonDao(database: AkwukwoDatabase): LessonDao = database.lessonDao()
}