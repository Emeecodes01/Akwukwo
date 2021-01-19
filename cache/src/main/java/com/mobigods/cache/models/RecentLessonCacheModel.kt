package com.mobigods.cache.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mobigods.domain.models.Lesson

@Entity(tableName = "recent_lessons")
data class RecentLessonCacheModel (
    @PrimaryKey
    val id: String,
    val watchedDuration: Long,
    @Embedded
    val lesson: LessonCacheModel,
)