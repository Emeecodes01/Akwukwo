package com.mobigods.domain.interactors.subjects

import com.google.common.truth.Truth
import com.google.common.truth.Truth.*
import com.mobigods.domain.interactors.subjects.testutils.DataGenerator
import com.mobigods.domain.interactors.subjects.testutils.TestExecutionThreadImpl
import com.mobigods.domain.models.Subject
import com.mobigods.domain.repository.local.AkwukwoSubjectsLocalRepository
import com.mobigods.domain.repository.remote.AkwukwoSubjectsRemoteRepository
import com.mobigods.domain.thread.ExecutionThread
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.slot
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class GetSubjectsRemoteUseCaseTest {

    private lateinit var getSubjectsRemoteUseCase: GetSubjectsRemoteUseCase

    private val executionThread: ExecutionThread = TestExecutionThreadImpl()

    @MockK
    lateinit var remoteRepository: AkwukwoSubjectsRemoteRepository

    @MockK
    lateinit var localRepository: AkwukwoSubjectsLocalRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        getSubjectsRemoteUseCase = GetSubjectsRemoteUseCase(executionThread, remoteRepository, localRepository)
    }


    @Test
    fun `verify that fetchSubjects and saveSubjects is called when usecase is invoked`() = runBlockingTest {
        stubSubjects(DataGenerator.generateSubjects(2))
        getSubjectsRemoteUseCase.invoke()


        coVerify (exactly = 1) { remoteRepository.fetchSubjects() }
        coVerify (exactly = 1) { localRepository.saveSubjects(any()) }
    }


    @Test
    fun `verify that saveSubjects is called with the correct parameters`() = runBlockingTest {
        val calling = DataGenerator.generateSubjects(2)

        val slot = slot<List<Subject>>()
        coEvery { remoteRepository.fetchSubjects() } returns calling
        coEvery { localRepository.saveSubjects(capture(slot)) } returns listOf(1L)

        getSubjectsRemoteUseCase.invoke()

        val result = slot.captured

        assertThat(result).isEqualTo(calling)

        assertThat(result).hasSize(2)
    }


    private fun stubSubjects(subjects: List<Subject> = emptyList()) {
        coEvery { remoteRepository.fetchSubjects() } returns subjects
        coEvery { localRepository.saveSubjects(any()) } returns emptyList()
    }


}