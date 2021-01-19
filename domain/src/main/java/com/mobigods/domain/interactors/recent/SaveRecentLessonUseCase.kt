package com.mobigods.domain.interactors.recent

import com.mobigods.domain.interactors.base.NoResultSuspendUseCase
import com.mobigods.domain.models.Lesson
import com.mobigods.domain.models.RecentLesson
import com.mobigods.domain.repository.local.AkwukwoRecentLessonsLocalRepository
import com.mobigods.domain.thread.ExecutionThread
import javax.inject.Inject

class SaveRecentLessonUseCase @Inject constructor (
    executionThread: ExecutionThread,
    private val localRepository: AkwukwoRecentLessonsLocalRepository
): NoResultSuspendUseCase<SaveRecentLessonUseCase.Parameter>(executionThread) {


    override suspend fun execute(params: Parameter?) {
        checkNotNull(params)
        val recentLesson = RecentLesson(
            id = params.id, watchedDuration = params.watchedDuration,
            lesson = Lesson(
                chapter_id = params.chapter_id, icon = params.icon, id = params.lesson_id,
                media_url = params.media_url, name = params.name, subject_id = params.subject_id)
        )

        localRepository.saveRecentLesson(recentLesson)
    }

    data class Parameter (
        val id: String,
        val watchedDuration: Long,
        val chapter_id: Int,
        val icon: String,
        val lesson_id: Int,
        val media_url: String,
        val name: String,
        val subject_id: Int
    )
}