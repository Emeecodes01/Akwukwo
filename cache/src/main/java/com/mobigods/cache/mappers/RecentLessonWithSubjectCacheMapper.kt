package com.mobigods.cache.mappers

import com.mobigods.cache.models.RecentLessonCacheModel
import com.mobigods.cache.models.RecentLessonWithSubjectCacheModel
import com.mobigods.core.base.BaseMapper
import com.mobigods.domain.models.RecentLessonWithSubject
import javax.inject.Inject

class RecentLessonWithSubjectCacheMapper @Inject constructor(
    private val recentLessonCacheModelMapper: RecentLessonCacheModelMapper,
    private val subjectCacheModelMapper: SubjectCacheModelMapper
): BaseMapper<RecentLessonWithSubjectCacheModel, RecentLessonWithSubject> {


    override fun mapTo(to: RecentLessonWithSubject): RecentLessonWithSubjectCacheModel {
        return RecentLessonWithSubjectCacheModel(
            recentLessonCacheModel = recentLessonCacheModelMapper.mapTo(to.recentLesson),
            subjectCacheModel = subjectCacheModelMapper.mapTo(to.subject)
        )
    }

    override fun mapFrom(from: RecentLessonWithSubjectCacheModel): RecentLessonWithSubject {
        return RecentLessonWithSubject(
            recentLesson = recentLessonCacheModelMapper.mapFrom(from.recentLessonCacheModel),
            subject =   subjectCacheModelMapper.mapFrom(from.subjectCacheModel)
        )
    }

}