package com.mobigods.presentation.mappers

import com.mobigods.core.base.BaseMapper
import com.mobigods.domain.models.RecentLessonWithSubject
import com.mobigods.presentation.models.RecentLessonWithSubjectModel
import com.mobigods.presentation.models.SubjectModel
import javax.inject.Inject

class RecentLessonWithSubjectModelMapper @Inject constructor(
    private val recentLessonModelMapper: RecentLessonModelMapper,
    private val subjectModelMapper: SubjectModelMapper
): BaseMapper<RecentLessonWithSubjectModel, RecentLessonWithSubject> {


    override fun mapTo(to: RecentLessonWithSubject): RecentLessonWithSubjectModel {
        return RecentLessonWithSubjectModel(recentLessonModel = recentLessonModelMapper.mapTo(to.recentLesson),
            subjectModel = subjectModelMapper.mapTo(to.subject))
    }


    override fun mapFrom(from: RecentLessonWithSubjectModel): RecentLessonWithSubject {
        return RecentLessonWithSubject(
            recentLesson = recentLessonModelMapper.mapFrom(from.recentLessonModel),
            subject = subjectModelMapper.mapFrom(from.subjectModel)
        )
    }

}