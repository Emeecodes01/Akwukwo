package com.mobigods.domain.interactors.subjects

import com.mobigods.domain.interactors.base.SynchronousUseCase
import com.mobigods.domain.repository.local.AkwukwoSubjectsLocalRepository
import javax.inject.Inject

class LastFetchedUseCase @Inject constructor(
    private val localRepository: AkwukwoSubjectsLocalRepository
): SynchronousUseCase<Unit, Long>() {

    override fun execute(params: Unit?): Long {
        return localRepository.lastSynced
    }

}