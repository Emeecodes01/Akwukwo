package com.mobigods.cache.impl

import com.mobigods.cache.db.dao.LessonDao
import com.mobigods.cache.mappers.LessonCacheModelMapper
import com.mobigods.domain.models.Lesson
import com.mobigods.domain.repository.local.AkwukwoLessonLocalRepository
import javax.inject.Inject


class AkwukwoLessonLocalRepositoryImpl @Inject constructor(
    private val lessonDao: LessonDao,
    private val lessonModelMapper: LessonCacheModelMapper
): AkwukwoLessonLocalRepository {


    override suspend fun saveLesson(lesson: Lesson) {
        lessonDao.saveLesson(lessonModelMapper.mapTo(lesson))
    }

    override suspend fun getLessonWithId(lessonId: Int): Lesson {
        val lessonModel = lessonDao.getLessonWithId(lessonId)
        return lessonModelMapper.mapFrom(lessonModel)
    }

}