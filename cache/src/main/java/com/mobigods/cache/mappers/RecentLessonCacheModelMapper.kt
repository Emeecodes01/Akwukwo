package com.mobigods.cache.mappers

import com.mobigods.cache.models.RecentLessonCacheModel
import com.mobigods.core.base.BaseMapper
import com.mobigods.domain.models.RecentLesson
import javax.inject.Inject

class RecentLessonCacheModelMapper @Inject constructor(
    private val lessonCacheModelMapper: LessonCacheModelMapper
): BaseMapper<RecentLessonCacheModel, RecentLesson> {


    override fun mapTo(to: RecentLesson): RecentLessonCacheModel {
        return RecentLessonCacheModel(
            id = to.id,
            watchedDuration = to.watchedDuration,
            lesson = lessonCacheModelMapper.mapTo(to.lesson)
        )
    }

    override fun mapFrom(from: RecentLessonCacheModel): RecentLesson {
        return RecentLesson(
            id = from.id,
            watchedDuration = from.watchedDuration,
            lesson = lessonCacheModelMapper.mapFrom(from.lesson)
        )
    }

}