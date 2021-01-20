package com.mobigods.domain.interactors.recent

import com.mobigods.domain.interactors.base.SuspendUseCase
import com.mobigods.domain.models.Lesson
import com.mobigods.domain.repository.local.AkwukwoRecentLessonsLocalRepository
import com.mobigods.domain.thread.ExecutionThread
import javax.inject.Inject

class GetLessonUseCase @Inject constructor (
    private val executionThread: ExecutionThread,
    private val localRepository: AkwukwoRecentLessonsLocalRepository
): SuspendUseCase<Int, Lesson>(executionThread) {

    override suspend fun execute(params: Int?): Lesson {
        checkNotNull(params)
        return localRepository.getLessonSaved(params)
    }

}