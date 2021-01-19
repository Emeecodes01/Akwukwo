package com.mobigods.presentation.mappers

import com.mobigods.core.base.BaseMapper
import com.mobigods.domain.models.RecentLesson
import com.mobigods.presentation.models.RecentLessonModel
import javax.inject.Inject

class RecentLessonModelMapper @Inject constructor (
    private val lessonModelMapper: LessonModelMapper
): BaseMapper<RecentLessonModel, RecentLesson> {

    override fun mapTo(to: RecentLesson): RecentLessonModel {
        return RecentLessonModel(
            id = to.id,
            watchedDuration = to.watchedDuration,
            lesson = lessonModelMapper.mapTo(to.lesson),
            time = to.time,
        )
    }

    override fun mapFrom(from: RecentLessonModel): RecentLesson {
        return RecentLesson(
            id = from.id,
            watchedDuration = from.watchedDuration,
            time = from.time,
            lesson = lessonModelMapper.mapFrom(from.lesson)
        )
    }
}