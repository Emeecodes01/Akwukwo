package com.mobigods.presentation.models

import android.os.Parcelable
import com.mobigods.domain.models.Lesson
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ChapterModel(
    val id: Int,
    val lessons: List<LessonModel>,
    val name: String
): Parcelable