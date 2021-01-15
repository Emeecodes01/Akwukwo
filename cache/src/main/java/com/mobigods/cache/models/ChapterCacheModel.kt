package com.mobigods.cache.models

import com.mobigods.domain.models.Lesson

data class ChapterCacheModel(
    val id: Int,
    val lessons: List<LessonCacheModel>,
    val name: String
)