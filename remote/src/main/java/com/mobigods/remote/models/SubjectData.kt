package com.mobigods.remote.models

import com.mobigods.domain.models.Subject

data class SubjectData(
    val message: String,
    val status: String,
    val subjects: List<SubjectRemoteModel>
)
