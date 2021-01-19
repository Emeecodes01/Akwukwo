package com.mobigods.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mobigods.cache.db.converters.ChapterListTypeConverter
import com.mobigods.cache.db.dao.LessonDao
import com.mobigods.cache.db.dao.RecentLessonDao
import com.mobigods.cache.db.dao.SubjectDao
import com.mobigods.cache.models.LessonCacheModel
import com.mobigods.cache.models.RecentLessonCacheModel
import com.mobigods.cache.models.SubjectCacheModel
import com.mobigods.cache.utils.CacheConstants

@Database (
    entities = [SubjectCacheModel::class, RecentLessonCacheModel::class, LessonCacheModel::class],
    version = CacheConstants.dbVersion,
    exportSchema = true
)
@TypeConverters(
    ChapterListTypeConverter::class
)
abstract class AkwukwoDatabase: RoomDatabase(){

    abstract fun subjectDao(): SubjectDao
    abstract fun recentLessonDao(): RecentLessonDao
    abstract fun lessonDao(): LessonDao

}