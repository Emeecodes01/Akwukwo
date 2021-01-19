package com.mobigods.domain.repository.local

import com.mobigods.domain.models.RecentLesson
import com.mobigods.domain.models.RecentLessonWithSubject
import com.mobigods.domain.models.Subject
import kotlinx.coroutines.flow.Flow

interface AkwukwoRecentLessonsLocalRepository {
    suspend fun saveRecentLesson(lesson: RecentLesson)
    fun getRecentLessons(): Flow<List<RecentLesson>>
    fun getRecentLessonsWithSubject(): Flow<List<RecentLessonWithSubject>>
}