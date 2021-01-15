package com.mobigods.remote.models

import com.mobigods.domain.models.Lesson

data class ChapterRemoteModel(
    val id: Int,
    val lessons: List<LessonRemoteModel>,
    val name: String
)
