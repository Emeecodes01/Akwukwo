package com.mobigods.cache.models

import androidx.room.ColumnInfo

data class LessonCacheModel (
    val chapter_id: Int,
    val icon: String,
    @ColumnInfo(name = "lesson_id")
    val id: Int,
    val media_url: String,
    val name: String,
    val subject_id: Int
)