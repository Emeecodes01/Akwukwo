package com.mobigods.domain.interactors.subjects

import com.google.common.truth.Truth.*
import com.mobigods.domain.repository.local.AkwukwoSubjectsLocalRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test


class LastFetchedUseCaseTest {

    @MockK
    lateinit var localRepository: AkwukwoSubjectsLocalRepository

    @MockK
    lateinit var lastFetchedUseCase: LastFetchedUseCase


    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        lastFetchedUseCase = LastFetchedUseCase(localRepository)
    }

    @Test
    fun `LastFetchedUseCase returns lastSynced`() {
        stubResponse()
        val value = lastFetchedUseCase.execute()

        assertThat(value)
            .isEqualTo(1000L)
    }


    private fun stubResponse() {
        every { localRepository.lastSynced } returns 1000L
    }

}