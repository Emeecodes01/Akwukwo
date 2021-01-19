package com.mobigods.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class LessonCacheModel (
    @ColumnInfo(name = "lesson_id")
    val id: Int,
    val chapter_id: Int,
    val icon: String,
    val media_url: String,
    val name: String,
    val subject_id: Int
)