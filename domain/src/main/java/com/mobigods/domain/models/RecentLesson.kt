package com.mobigods.domain.models

data class RecentLesson (
    val id: String,
    val watchedDuration: Long,
    val time: Long,
    val lesson: Lesson,
)
