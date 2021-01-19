package com.mobigods.presentation.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlayerData(
    val mediaUrl: String,
    val chapterName: String,
    val lessonName: String,
    val lessonId: Int,
    val recentId: String,
    val watchedDuration: Long
): Parcelable {

    companion object {
        fun createFromRecentLesson(recentLessonWithSubjectModel: RecentLessonWithSubjectModel): PlayerData {
            val chapterId = recentLessonWithSubjectModel.recentLessonModel.lesson.chapter_id
            val chapterName = recentLessonWithSubjectModel.subjectModel.chapters.find { it.id == chapterId }?.name ?: ""
            val mediaUrl = recentLessonWithSubjectModel.recentLessonModel.lesson.media_url
            val lessonName = recentLessonWithSubjectModel.recentLessonModel.lesson.name
            val lessonId = recentLessonWithSubjectModel.recentLessonModel.lesson.id
            val watchedDuration = recentLessonWithSubjectModel.recentLessonModel.watchedDuration

            return PlayerData(mediaUrl, chapterName, lessonName, lessonId, recentLessonWithSubjectModel.recentLessonModel.id, watchedDuration)
        }


        fun createFromLesson(lessonModel: LessonModel, chapterName: String): PlayerData {
            val mediaUrl = lessonModel.media_url
            val lessonName = lessonModel.name
            val lessonId = lessonModel.id
            val watchedDuration = 0L

            return PlayerData(mediaUrl, chapterName, lessonName, lessonId, "", watchedDuration)
        }

    }

}
