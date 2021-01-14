package com.mobigods.domain.models

data class Data(
    val message: String,
    val status: String,
    val subjects: List<Subject>
)