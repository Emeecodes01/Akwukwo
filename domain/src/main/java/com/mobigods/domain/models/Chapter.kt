package com.mobigods.domain.models

data class Chapter(
    val id: Int,
    val lessons: List<Lesson>,
    val name: String
)