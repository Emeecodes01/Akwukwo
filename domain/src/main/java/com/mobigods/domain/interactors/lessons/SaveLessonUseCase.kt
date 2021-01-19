package com.mobigods.domain.interactors.lessons

import com.mobigods.domain.interactors.base.SuspendUseCase
import com.mobigods.domain.models.Lesson
import com.mobigods.domain.repository.local.AkwukwoLessonLocalRepository
import com.mobigods.domain.thread.ExecutionThread
import javax.inject.Inject

class SaveLessonUseCase @Inject constructor(
    private val executionThread: ExecutionThread,
    private val localRepository: AkwukwoLessonLocalRepository
): SuspendUseCase<Lesson, Unit>(executionThread) {

    override suspend fun execute(params: Lesson?) {
        checkNotNull(params)
        localRepository.saveLesson(params)
    }
}