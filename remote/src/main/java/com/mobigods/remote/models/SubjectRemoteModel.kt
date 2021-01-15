package com.mobigods.remote.models

import com.mobigods.domain.models.Chapter

data class SubjectRemoteModel(
    val chapters: List<ChapterRemoteModel>,
    val icon: String,
    val id: Int,
    val name: String
)
