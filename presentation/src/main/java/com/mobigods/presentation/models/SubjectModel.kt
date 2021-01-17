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
): Parcelable {

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        other as SubjectModel

        return other.chapters == chapters &&
                other.icon == icon && other.id == id && other.name == name
    }


    override fun hashCode(): Int {
        var hash = 7
        hash = 31 * hash + chapters.hashCode()
        hash = 31 * hash + icon.hashCode()
        hash = 31 * hash + id.hashCode()
        hash = 31 * hash + name.hashCode()
        return hash
    }

}