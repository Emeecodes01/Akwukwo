package com.mobigods.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mobigods.cache.db.converters.ChapterListTypeConverter
import com.mobigods.cache.db.dao.SubjectDao
import com.mobigods.cache.models.SubjectCacheModel
import com.mobigods.cache.utils.CacheConstants

@Database (
    entities = [SubjectCacheModel::class],
    version = CacheConstants.dbVersion,
    exportSchema = true
)
@TypeConverters(
    ChapterListTypeConverter::class
)
abstract class AkwukwoDatabase: RoomDatabase(){

    abstract fun subjectDao(): SubjectDao
}