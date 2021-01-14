package com.mobigods.domain.models

data class Lesson(
    val chapter_id: Int,
    val icon: String,
    val id: Int,
    val media_url: String,
    val name: String,
    val subject_id: Int
)