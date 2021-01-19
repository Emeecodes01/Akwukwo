package com.mobigods.domain.interactors.recent

import com.mobigods.domain.interactors.base.FlowUseCase
import com.mobigods.domain.models.RecentLesson
import com.mobigods.domain.repository.local.AkwukwoRecentLessonsLocalRepository
import com.mobigods.domain.thread.ExecutionThread
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecentLessonsUseCase @Inject constructor (
    executionThread: ExecutionThread,
    private val localRepository: AkwukwoRecentLessonsLocalRepository
): FlowUseCase<Unit, List<RecentLesson>>(executionThread) {


    override fun buildFlowUseCase(params: Unit?): Flow<List<RecentLesson>> {
        return localRepository.getRecentLessons()
    }

}