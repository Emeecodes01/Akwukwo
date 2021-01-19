package com.mobigods.cache.impl

import com.mobigods.cache.db.dao.RecentLessonDao
import com.mobigods.cache.mappers.RecentLessonCacheModelMapper
import com.mobigods.domain.models.RecentLesson
import com.mobigods.domain.repository.local.AkwukwoRecentLessonsLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AkwukwoRecentLessonsLocalRepositoryImpl @Inject constructor(
    private val recentLessonDao: RecentLessonDao,
    private val recentLessonCacheModelMapper: RecentLessonCacheModelMapper
) : AkwukwoRecentLessonsLocalRepository {

    override suspend fun saveRecentLesson(lesson: RecentLesson) {
        recentLessonDao.saveRecentLesson(recentLessonCacheModelMapper.mapTo(lesson))
    }


    override fun getRecentLessons(): Flow<List<RecentLesson>> {
        return recentLessonDao.getRecentLessons().flatMapConcat {
            flowOf(it.map { recentLessonCacheModel ->
                recentLessonCacheModelMapper.mapFrom(
                    recentLessonCacheModel
                )
            })
        }
    }
}