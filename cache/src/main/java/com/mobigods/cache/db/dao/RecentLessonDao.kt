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

    @Query("SELECT * FROM recent_lessons ORDER BY `current_time` DESC")
    abstract fun getRecentLessonsWithSubject(): Flow<List<RecentLessonWithSubjectCacheModel>>

    @Query("SELECT * FROM recent_lessons WHERE lesson_id =:lessonId")
    abstract suspend fun getRecentLessonsWithIdOneShot(lessonId: Int): List<RecentLessonCacheModel>

    @Query("UPDATE recent_lessons SET recent_id=:recentId, watchedDuration =:watchDuration, `current_time` =:currentTime  WHERE (lesson_id =:lesson_id) AND (chapter_id =:chapterId) AND (subject_id =:subjectId) ")
    abstract suspend fun updateRecentLesson(recentId: String, watchDuration: Long, currentTime: Long, lesson_id: Int, chapterId: Int, subjectId: Int)
}