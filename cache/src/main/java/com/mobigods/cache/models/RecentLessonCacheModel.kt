package com.mobigods.cache.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mobigods.domain.models.Lesson

@Entity(tableName = "recent_lessons")
data class RecentLessonCacheModel (
    @PrimaryKey
    @ColumnInfo(name = "recent_id")
    val id: String = "",
    val watchedDuration: Long = 0,
    @ColumnInfo(name = "current_time")
    val time: Long = 0L,
    @Embedded
    val lesson: LessonCacheModel,
)