package com.mobigods.domain.interactors.subjects

import com.mobigods.domain.interactors.base.SuspendUseCase
import com.mobigods.domain.models.Subject
import com.mobigods.domain.repository.local.AkwukwoSubjectsLocalRepository
import com.mobigods.domain.repository.remote.AkwukwoSubjectsRemoteRepository
import com.mobigods.domain.thread.ExecutionThread
import javax.inject.Inject

class GetSubjectsRemoteUseCase @Inject constructor(
    private val executionThread: ExecutionThread,
    private val remoteRepository: AkwukwoSubjectsRemoteRepository
): SuspendUseCase<Unit, Unit>(executionThread) {


    override suspend fun execute(params: Unit?) {
        remoteRepository.fetchSubjects()
    }

}