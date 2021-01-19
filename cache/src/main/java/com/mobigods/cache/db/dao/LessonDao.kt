package com.mobigods.cache.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mobigods.cache.models.LessonCacheModel
import com.mobigods.cache.models.RecentLessonCacheModel
import com.mobigods.domain.models.Lesson

@Dao
abstract class LessonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveLesson(lessonCacheModel: LessonCacheModel)

    @Query("SELECT * FROM lessons WHERE lesson_id =:lessonId limit 1")
    abstract suspend fun getLessonWithId(lessonId: Int): LessonCacheModel


}