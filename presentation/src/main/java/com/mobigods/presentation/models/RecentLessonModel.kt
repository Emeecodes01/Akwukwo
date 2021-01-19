package com.mobigods.presentation.models

import android.os.Parcelable
import com.mobigods.domain.models.Lesson
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecentLessonModel (
    val id: String,
    val chapterName: String,
    val watchedDuration: Long,
    val lesson: LessonModel,
): Parcelable