package com.mobigods.cache.mappers

import com.mobigods.cache.models.ChapterCacheModel
import com.mobigods.core.base.BaseMapper
import com.mobigods.domain.models.Chapter
import java.lang.Exception
import javax.inject.Inject

class ChapterCacheModelMapper @Inject constructor(
    private val lessonCacheModelMapper: LessonCacheModelMapper
): BaseMapper<ChapterCacheModel, Chapter> {

    override fun mapTo(to: Chapter): ChapterCacheModel {
        return ChapterCacheModel (
            id = to.id,
            name = to.name,
            lessons = to.lessons.map { lessonCacheModelMapper.mapTo(it) }
        )
    }

    override fun mapFrom(from: ChapterCacheModel): Chapter {
        return Chapter(
            id = from.id,
            name = from.name,
            lessons = from.lessons.map { lessonCacheModelMapper.mapFrom(it) }
        )
    }


}