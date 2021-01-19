package com.mobigods.cache.mappers

import com.mobigods.cache.models.LessonCacheModel
import com.mobigods.core.base.BaseMapper
import com.mobigods.domain.models.Lesson
import javax.inject.Inject


class LessonCacheModelMapper @Inject constructor(): BaseMapper<LessonCacheModel, Lesson> {

    override fun mapTo(to: Lesson): LessonCacheModel {
        return LessonCacheModel(
            chapter_id = to.chapter_id,
            icon = to.icon,
            media_url = to.media_url,
            id = to.id,
            name = to.name,
            subject_id = to.subject_id
        )
    }

    override fun mapFrom(from: LessonCacheModel): Lesson {
        return Lesson (
            chapter_id = from.chapter_id,
            icon = from.icon,
            media_url = from.media_url,
            id = from.id,
            name = from.name,
            subject_id = from.subject_id
        )
    }
}