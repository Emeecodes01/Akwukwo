package com.mobigods.domain.interactors.subjects

import com.google.common.truth.Truth
import com.google.common.truth.Truth.*
import com.mobigods.domain.interactors.subjects.testutils.DataGenerator
import com.mobigods.domain.interactors.subjects.testutils.TestExecutionThreadImpl
import com.mobigods.domain.models.Subject
import com.mobigods.domain.repository.local.AkwukwoSubjectsLocalRepository
import com.mobigods.domain.thread.ExecutionThread
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single
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
        getSubjectsLocalUseCase.execute()

        coVerify(exactly = 1) {
            localRepository.getAllSubjects()
        }
    }


    @Test
    fun `verify that calling invoke returns the list of subject`() = runBlockingTest {
        val callingValues = DataGenerator.generateSubjects(2)
        stubSubjects(callingValues)
        val returnedValues = getSubjectsLocalUseCase.execute()

        assertThat(returnedValues.first())
            .hasSize(2)

        assertThat(callingValues)
            .isEqualTo(returnedValues.first())
    }


    private fun stubSubjects(subjects: List<Subject> = emptyList()) {
        coEvery { localRepository.getAllSubjects() } returns flow { emit(subjects) }
    }


}