package com.mobigods.domain.interactors.subjects

import com.mobigods.domain.interactors.base.FlowUseCase
import com.mobigods.domain.interactors.base.SuspendUseCase
import com.mobigods.domain.models.Subject
import com.mobigods.domain.repository.local.AkwukwoSubjectsLocalRepository
import com.mobigods.domain.thread.ExecutionThread
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSubjectsLocalUseCase @Inject constructor(
    private val executionThread: ExecutionThread,
    private val localRepository: AkwukwoSubjectsLocalRepository
): FlowUseCase<Unit, List<Subject>>(executionThread) {


    override fun buildFlowUseCase(params: Unit?): Flow<List<Subject>> {
        return localRepository.getAllSubjects()
    }

}