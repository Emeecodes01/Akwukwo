package com.mobigods.presentation.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class LessonModel(
    val chapter_id: Int,
    val icon: String,
    val id: Int,
    val media_url: String,
    val name: String,
    val subject_id: Int
) : Parcelable {

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        other as LessonModel

        return other.chapter_id == chapter_id &&
                other.icon == icon && other.id == id && other.media_url == media_url
                && other.name == name && other.subject_id == subject_id
    }


    override fun hashCode(): Int {
        var hash = 7
        hash = 31 * hash + chapter_id.hashCode()
        hash = 31 * hash + icon.hashCode()
        hash = 31 * hash + id.hashCode()
        hash = 31 * hash + media_url.hashCode()
        hash = 31 * hash + name.hashCode()
        hash = 31 * hash + subject_id.hashCode()
        return hash
    }
}
