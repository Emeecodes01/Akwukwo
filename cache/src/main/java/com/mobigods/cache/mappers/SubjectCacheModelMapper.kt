package com.mobigods.cache.mappers

import com.mobigods.cache.models.SubjectCacheModel
import com.mobigods.core.base.BaseMapper
import com.mobigods.domain.models.Subject
import javax.inject.Inject

class SubjectCacheModelMapper @Inject constructor(
    private val chapterCacheModelMapper: ChapterCacheModelMapper
): BaseMapper<SubjectCacheModel, Subject> {

    override fun mapTo(to: Subject): SubjectCacheModel {
        return SubjectCacheModel (
            id = to.id,
            name = to.name,
            icon = to.icon,
            chapters = to.chapters.map { chapterCacheModelMapper.mapTo(it) }

        )
    }

    override fun mapFrom(from: SubjectCacheModel): Subject {
        return Subject(
            id = from.id,
            name = from.name,
            icon = from.icon,
            chapters = from.chapters.map { chapterCacheModelMapper.mapFrom(it) }
        )
    }

}