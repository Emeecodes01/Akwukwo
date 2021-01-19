package com.mobigods.cache.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mobigods.cache.models.RecentLessonCacheModel
import com.mobigods.cache.models.RecentLessonWithSubjectCacheModel
import kotlinx.coroutines.flow.Flow


@Dao
abstract class RecentLessonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveRecentLesson(recentLessonCacheModel: RecentLessonCacheModel): Long

    @Query("SELECT * FROM recent_lessons")
    abstract fun getRecentLessons(): Flow<List<RecentLessonCacheModel>>

    @Query("SELECT * FROM recent_lessons")
    abstract fun getRecentLessonsWithSubject(): Flow<List<RecentLessonWithSubjectCacheModel>>
}