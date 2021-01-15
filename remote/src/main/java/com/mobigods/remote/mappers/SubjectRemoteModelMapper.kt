package com.mobigods.remote.mappers

import com.mobigods.core.base.BaseMapper
import com.mobigods.domain.models.Subject
import com.mobigods.remote.models.SubjectRemoteModel
import javax.inject.Inject

class SubjectRemoteModelMapper @Inject constructor(
    private val chapterRemoteModelMapper: ChapterRemoteModelMapper
): BaseMapper<SubjectRemoteModel, Subject> {

    override fun mapTo(to: Subject): SubjectRemoteModel {
        return SubjectRemoteModel(
            name = to.name,
            id = to.id,
            icon = to.icon,
            chapters = to.chapters.map { chapterRemoteModelMapper.mapTo(it) }
        )
    }


    override fun mapFrom(from: SubjectRemoteModel): Subject {
        throw Exception("Not implemented")
    }

}