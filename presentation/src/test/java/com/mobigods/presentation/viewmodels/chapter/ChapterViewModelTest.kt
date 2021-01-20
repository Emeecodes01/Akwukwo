package com.mobigods.presentation.viewmodels.chapter

import com.mobigods.domain.interactors.recent.SaveRecentLessonUseCase
import com.mobigods.presentation.mappers.LessonModelMapper
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.Before

import org.junit.Assert.*

class ChapterViewModelTest {

    @MockK
    lateinit var saveRecentLessonUseCase: SaveRecentLessonUseCase

    private val mapper = LessonModelMapper()


    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

}