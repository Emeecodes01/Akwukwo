package com.mobigods.domain.interactors.recent

import com.mobigods.domain.interactors.base.FlowUseCase
import com.mobigods.domain.models.RecentLessonWithSubject
import com.mobigods.domain.repository.local.AkwukwoRecentLessonsLocalRepository
import com.mobigods.domain.thread.ExecutionThread
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecentLessonWithSubjectUseCase @Inject constructor (
    private val executionThread: ExecutionThread,
    private val localRepository: AkwukwoRecentLessonsLocalRepository
): FlowUseCase<Unit, List<RecentLessonWithSubject>>(executionThread){

    override fun buildFlowUseCase(params: Unit?): Flow<List<RecentLessonWithSubject>> {
        return localRepository.getRecentLessonsWithSubject()
    }

}