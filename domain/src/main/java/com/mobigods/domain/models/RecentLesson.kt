package com.mobigods.domain.models

data class RecentLesson (
    val id: String,
    val chapterName: String,
    val watchedDuration: Long,
    val lesson: Lesson,
)
