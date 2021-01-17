package com.mobigods.presentation.mappers

import com.mobigods.core.base.BaseMapper
import com.mobigods.domain.models.Subject
import com.mobigods.presentation.models.SubjectModel
import javax.inject.Inject

class SubjectModelMapper @Inject constructor(private val chapterModelMapper: ChapterModelMapper): BaseMapper<SubjectModel, Subject> {

    override fun mapTo(to: Subject): SubjectModel {
        return SubjectModel(
            name = to.name,
            id = to.id,
            icon = to.icon,
            chapters = to.chapters.map { chapterModelMapper.mapTo(it) }
        )
    }

    override fun mapFrom(from: SubjectModel): Subject {
        TODO("Not yet implemented")
    }

}