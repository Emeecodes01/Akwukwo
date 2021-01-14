package com.mobigods.domain.models

data class Subject(
    val chapters: List<Chapter>,
    val icon: String,
    val id: Int,
    val name: String
)