package com.mobigods.presentation.models

import android.os.Parcelable
import com.mobigods.domain.models.Chapter
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SubjectModel (
    val chapters: List<ChapterModel>,
    val icon: String,
    val id: Int,
    val name: String
): Parcelable