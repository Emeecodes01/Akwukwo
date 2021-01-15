package com.mobigods.cache.module

import com.mobigods.cache.db.AkwukwoDatabase
import com.mobigods.cache.db.dao.SubjectDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataBaseModule::class])
class LocalDaoModule {

    @Provides
    @Singleton
    fun provideSubjectDao(database: AkwukwoDatabase): SubjectDao
    = database.subjectDao()


}