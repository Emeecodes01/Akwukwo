package com.mobigods.domain.interactors.subjects

import com.google.common.truth.Truth
import com.mobigods.domain.interactors.subjects.testutils.DataGenerator
import com.mobigods.domain.interactors.subjects.testutils.TestExecutionThreadImpl
import com.mobigods.domain.models.Subject
import com.mobigods.domain.repository.local.AkwukwoSubjectsLocalRepository
import com.mobigods.domain.thread.ExecutionThread
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class GetSubjectsLocalUseCaseTest {
    private lateinit var getSubjectsLocalUseCase: GetSubjectsLocalUseCase

    private val executionThread: ExecutionThread = TestExecutionThreadImpl()

    @MockK
    lateinit var localRepository: AkwukwoSubjectsLocalRepository


    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        getSubjectsLocalUseCase = GetSubjectsLocalUseCase(executionThread, localRepository)
    }


    @Test
    fun `verify that getAllSubjects is called when execute is called`() = runBlockingTest {
        stubSubjects(DataGenerator.generateSubjects(2))
        getSubjectsLocalUseCase.invoke()

        coVerify(exactly = 1) {
            localRepository.getAllSubjects()
        }
    }


    @Test
    fun `verify that calling invoke returns the list of subject`() = runBlockingTest {
        val callingValues = DataGenerator.generateSubjects(2)
        stubSubjects(callingValues)
        val returnedValues = getSubjectsLocalUseCase.invoke()

        Truth.assertThat(returnedValues)
            .hasSize(2)

        Truth.assertThat(callingValues)
            .isEqualTo(returnedValues)
    }


    private fun stubSubjects(subjects: List<Subject> = emptyList()) {
        coEvery { localRepository.getAllSubjects() } returns subjects
    }


}