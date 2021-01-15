package com.mobigods.cache.module

import android.content.Context
import androidx.room.Room
import com.mobigods.cache.db.AkwukwoDatabase
import com.mobigods.cache.utils.CacheConstants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context) =
        Room.databaseBuilder(context, AkwukwoDatabase::class.java, CacheConstants.dbName)
            .build()
}