package com.mobigods.presentation.models

import android.os.Parcelable
import com.mobigods.domain.models.Lesson
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ChapterModel(
    val id: Int,
    val lessons: List<LessonModel>,
    val name: String
): Parcelable {

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        other as ChapterModel
        return other.lessons == lessons && other.id == id && other.name == name
    }


    override fun hashCode(): Int {
        var hash = 7
        hash = 31 * hash + lessons.hashCode()
        hash = 31 * hash + id.hashCode()
        hash = 31 * hash + name.hashCode()
        return hash
    }

}