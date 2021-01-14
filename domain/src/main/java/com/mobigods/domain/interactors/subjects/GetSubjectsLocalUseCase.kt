package com.mobigods.domain.interactors.subjects

import com.mobigods.domain.interactors.base.SuspendUseCase
import com.mobigods.domain.models.Subject
import com.mobigods.domain.repository.local.AkwukwoSubjectsLocalRepository
import com.mobigods.domain.thread.ExecutionThread
import javax.inject.Inject

class GetSubjectsLocalUseCase @Inject constructor(
    private val executionThread: ExecutionThread,
    private val localRepository: AkwukwoSubjectsLocalRepository
): SuspendUseCase<Unit, List<Subject>>(executionThread) {

    override suspend fun execute(params: Unit?): List<Subject> {
        return localRepository.getAllSubjects()
    }

}