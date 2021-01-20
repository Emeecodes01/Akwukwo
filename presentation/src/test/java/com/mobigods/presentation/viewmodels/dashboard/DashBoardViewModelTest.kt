package com.mobigods.presentation.viewmodels.dashboard

import com.mobigods.domain.interactors.recent.GetRecentLessonWithSubjectUseCase
import com.mobigods.domain.interactors.recent.GetRecentLessonsUseCase
import com.mobigods.domain.interactors.subjects.GetSubjectsLocalUseCase
import com.mobigods.domain.interactors.subjects.GetSubjectsRemoteUseCase
import com.mobigods.domain.interactors.subjects.LastFetchedUseCase
import com.mobigods.presentation.mappers.*
import io.mockk.impl.annotations.MockK
import org.junit.Before

import org.junit.Assert.*

class DashBoardViewModelTest {


    @MockK
    lateinit var getSubjectsRemoteUseCase: GetSubjectsRemoteUseCase

    @MockK
    lateinit var getSubjectsLocalUseCase: GetSubjectsLocalUseCase

    @MockK
    lateinit var lastFetchedUseCase: LastFetchedUseCase

    @MockK
    lateinit var getRecentLessonsUseCase: GetRecentLessonsUseCase

    @MockK
    lateinit var getRecentLessonWithSubjectUseCase: GetRecentLessonWithSubjectUseCase


    private val recentLessonWithSubjectModelMapper = RecentLessonWithSubjectModelMapper(
        RecentLessonModelMapper(LessonModelMapper()), SubjectModelMapper(ChapterModelMapper(LessonModelMapper()))
    )

    private val recentLessonModelMapper: RecentLessonModelMapper = RecentLessonModelMapper(
        LessonModelMapper()
    )

    private val subjectModelMapper: SubjectModelMapper = SubjectModelMapper(ChapterModelMapper(LessonModelMapper()))



    @Before
    fun setUp() {

    }


}