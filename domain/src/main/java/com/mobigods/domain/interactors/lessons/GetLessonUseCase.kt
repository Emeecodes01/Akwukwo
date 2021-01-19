package com.mobigods.domain.interactors.lessons

import com.mobigods.domain.interactors.base.SuspendUseCase
import com.mobigods.domain.models.Lesson
import com.mobigods.domain.repository.local.AkwukwoLessonLocalRepository
import com.mobigods.domain.thread.ExecutionThread
import javax.inject.Inject

class GetLessonUseCase @Inject constructor (
    private val executionThread: ExecutionThread,
    private val localRepository: AkwukwoLessonLocalRepository
): SuspendUseCase<Int, Lesson>(executionThread) {

    override suspend fun execute(params: Int?): Lesson {
        checkNotNull(params)
        val result = localRepository.getLessonWithId(params)
        return result
    }

}