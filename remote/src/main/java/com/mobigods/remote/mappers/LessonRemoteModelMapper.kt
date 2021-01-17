package com.mobigods.remote.mappers

import com.mobigods.core.base.BaseMapper
import com.mobigods.domain.models.Lesson
import com.mobigods.remote.models.LessonRemoteModel
import javax.inject.Inject

class LessonRemoteModelMapper @Inject constructor(): BaseMapper<LessonRemoteModel, Lesson> {

    override fun mapTo(to: Lesson): LessonRemoteModel {
//        return LessonRemoteModel(
//            chapter_id = to.chapter_id,
//            icon = to.icon,
//            id = to.id,
//            media_url = to.media_url,
//            name = to.name,
//            subject_id = to.subject_id
//        )
        throw Exception("No need to be implemented")
    }

    override fun mapFrom(from: LessonRemoteModel): Lesson {
        return Lesson(
            chapter_id = from.chapter_id,
            icon = from.icon,
            id = from.id,
            media_url = from.media_url,
            name = from.name,
            subject_id = from.subject_id
        )
    }

}