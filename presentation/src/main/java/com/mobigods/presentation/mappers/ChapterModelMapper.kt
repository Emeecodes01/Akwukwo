package com.mobigods.presentation.mappers

import com.mobigods.core.base.BaseMapper
import com.mobigods.domain.models.Chapter
import com.mobigods.presentation.models.ChapterModel
import javax.inject.Inject

class ChapterModelMapper @Inject constructor(private val lessonModelMapper: LessonModelMapper): BaseMapper<ChapterModel, Chapter> {


    override fun mapTo(to: Chapter): ChapterModel {
        return ChapterModel (
            name = to.name,
            id = to.id,
            lessons = to.lessons.map { lessonModelMapper.mapTo(it) }
        )
    }

    override fun mapFrom(from: ChapterModel): Chapter {
        TODO("Not yet implemented")
    }
}