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
        getSubjectsRemoteUseCase = GetSubjectsRemoteUseCase(executionThread, remoteRepository)
    }


    @Test
    fun `verify that fetchSubjects and saveSubjects is called when usecase is invoked`() = runBlockingTest {
        stubSubjects(DataGenerator.generateSubjects(2))
        getSubjectsRemoteUseCase.invoke()

        coVerify (exactly = 1) { remoteRepository.fetchSubjects() }
    }


    private fun stubSubjects(subjects: List<Subject> = emptyList()) {
        coEvery { remoteRepository.fetchSubjects() } returns subjects
    }


}