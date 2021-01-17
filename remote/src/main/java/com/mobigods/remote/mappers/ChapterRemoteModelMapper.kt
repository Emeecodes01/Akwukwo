package com.mobigods.remote.mappers

import com.mobigods.core.base.BaseMapper
import com.mobigods.domain.models.Chapter
import com.mobigods.remote.models.ChapterRemoteModel
import javax.inject.Inject

class ChapterRemoteModelMapper @Inject constructor (
    private val lessonMapper: LessonRemoteModelMapper
): BaseMapper<ChapterRemoteModel, Chapter> {

    override fun mapTo(to: Chapter): ChapterRemoteModel {
//        return ChapterRemoteModel(
//            id = to.id,
//            name = to.name,
//            lessons = to.lessons.map { lessonMapper.mapTo(it) }
//        )
        throw Exception("Not Implement")
    }

    override fun mapFrom(from: ChapterRemoteModel): Chapter {
        return Chapter(
            id = from.id,
            name = from.name,
            lessons = from.lessons.map { lessonMapper.mapFrom(it) }
        )
    }


}