package com.mobigods.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mobigods.domain.models.Chapter

@Entity(tableName = "subjects")
data class SubjectCacheModel(
    val chapters: List<ChapterCacheModel>,
    val icon: String,
    @PrimaryKey
    val id: Int,
    val name: String
)