package com.mobigods.presentation.mappers

import com.mobigods.core.base.BaseMapper
import com.mobigods.domain.models.Lesson
import com.mobigods.presentation.models.LessonModel
import javax.inject.Inject

class LessonModelMapper @Inject constructor(): BaseMapper<LessonModel, Lesson> {
    override fun mapTo(to: Lesson): LessonModel {
        return LessonModel(
            id = to.id,
            chapter_id = to.chapter_id,
            icon = to.icon,
            media_url = to.media_url,
            name = to.name,
            subject_id = to.subject_id
        )
    }

    override fun mapFrom(from: LessonModel): Lesson {
        TODO("Not yet implemented")
    }


}