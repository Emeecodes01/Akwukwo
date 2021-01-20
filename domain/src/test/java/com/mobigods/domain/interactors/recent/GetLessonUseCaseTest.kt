package com.mobigods.domain.interactors.recent

import com.google.common.truth.Truth
import com.google.common.truth.Truth.*
import com.mobigods.domain.interactors.subjects.testutils.DataGenerator
import com.mobigods.domain.interactors.subjects.testutils.TestExecutionThreadImpl
import com.mobigods.domain.models.Lesson
import com.mobigods.domain.repository.local.AkwukwoRecentLessonsLocalRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import java.lang.IllegalStateException
import javax.inject.Inject

class GetLessonUseCaseTest {
    private val threadExecutor = TestExecutionThreadImpl()

    @MockK
    lateinit var localRepository: AkwukwoRecentLessonsLocalRepository

    private lateinit var getLessonUseCase: GetLessonUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        getLessonUseCase = GetLessonUseCase(threadExecutor, localRepository)
    }


    @Test(expected = IllegalStateException::class)
    fun `throw an execption when called with a null parameter`() = runBlockingTest {
        val lesson = DataGenerator.generateLesson()
        stubLesson(lesson)
        getLessonUseCase.invoke(null)
    }


    @Test
    fun `lesson is returned when invoke is called`() = runBlockingTest {
        val lesson = DataGenerator.generateLesson()
        stubLesson(lesson)

        val collectedLesson = getLessonUseCase.invoke(2)

        assertThat(collectedLesson)
            .isEqualTo(lesson)
    }


    private fun stubLesson(lesson: Lesson) {
        coEvery { localRepository.getLessonSaved(any()) } returns lesson
    }

}