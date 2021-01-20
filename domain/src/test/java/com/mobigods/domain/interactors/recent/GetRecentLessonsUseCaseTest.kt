package com.mobigods.domain.interactors.recent

import com.google.common.truth.Truth
import com.google.common.truth.Truth.*
import com.mobigods.domain.interactors.subjects.testutils.DataGenerator
import com.mobigods.domain.interactors.subjects.testutils.TestExecutionThreadImpl
import com.mobigods.domain.models.RecentLesson
import com.mobigods.domain.repository.local.AkwukwoRecentLessonsLocalRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class GetRecentLessonsUseCaseTest {

    private val threadExecutor = TestExecutionThreadImpl()

    @MockK
    lateinit var localRepository: AkwukwoRecentLessonsLocalRepository

    private lateinit var getRecentLessonUseCase: GetRecentLessonsUseCase


    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        getRecentLessonUseCase = GetRecentLessonsUseCase(threadExecutor, localRepository)
    }

    @Test
    fun `verify localRepository getRecentLessons is called`() {
        val recents = DataGenerator.generateRecentList(2)
        stubLocalRepo(recents)
        getRecentLessonUseCase.execute()
        coVerify(exactly = 1) { localRepository.getRecentLessons() }
    }


    @Test
    fun `returns the correct object when called`() = runBlockingTest {
        val recents = DataGenerator.generateRecentList(2)
        stubLocalRepo(recents)
        val recentLessonsFlow = getRecentLessonUseCase.execute()
        val recentsResult = recentLessonsFlow.first()

        assertThat(recentsResult)
            .hasSize(2)

        assertThat(recentsResult[0])
            .isEqualTo(recents[0])
    }


    private fun stubLocalRepo(recents: List<RecentLesson>) {
        coEvery { localRepository.getRecentLessons() } returns flow { emit(recents) }
    }


}