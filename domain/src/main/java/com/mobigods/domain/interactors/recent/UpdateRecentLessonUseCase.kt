package com.mobigods.domain.interactors.recent

import com.mobigods.domain.interactors.base.NoResultSuspendUseCase
import com.mobigods.domain.repository.local.AkwukwoRecentLessonsLocalRepository
import com.mobigods.domain.thread.ExecutionThread
import javax.inject.Inject

class UpdateRecentLessonUseCase @Inject constructor(
    private val executionThread: ExecutionThread,
    private val localRepository: AkwukwoRecentLessonsLocalRepository
): NoResultSuspendUseCase<UpdateRecentLessonUseCase.Parameter>(executionThread){

    override suspend fun execute(params: Parameter?) {
        checkNotNull(params)

        localRepository.updateRecentLessons (
            params.recentId, params.watchDuration,
            params.time, params.lessonId,
            params.chapterId, params.subjectId
        )

    }

    data class Parameter(
        val recentId: String,
        val watchDuration: Long,
        val time: Long,
        val lessonId: Int, val chapterId: Int,
        val subjectId: Int
    )
}