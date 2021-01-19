package com.mobigods.domain.repository.local

import com.mobigods.domain.models.Lesson

interface AkwukwoLessonLocalRepository {
    suspend fun saveLesson(lesson: Lesson)
    suspend fun getLessonWithId(lessonId: Int): Lesson
}