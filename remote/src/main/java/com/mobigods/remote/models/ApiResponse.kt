package com.mobigods.remote.models

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("data")
    val subjectData: SubjectData
)
