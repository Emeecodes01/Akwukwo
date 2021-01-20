package com.mobigods.remote.impl

import com.google.common.truth.Truth
import com.mobigods.domain.repository.local.AkwukwoSubjectsLocalRepository
import com.mobigods.remote.mappers.ChapterRemoteModelMapper
import com.mobigods.remote.mappers.LessonRemoteModelMapper
import com.mobigods.remote.mappers.SubjectRemoteModelMapper
import com.mobigods.remote.models.ApiResponse
import com.mobigods.remote.services.AkwukwoContentService
import com.mobigods.remote.testutils.RemoteDataGenerator
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class AkwukwoSubjectsRemoteRepositoryImplTest {

    @MockK
    lateinit var service: AkwukwoContentService


    @MockK
    lateinit var localRepository: AkwukwoSubjectsLocalRepository

    private val mapper = SubjectRemoteModelMapper(ChapterRemoteModelMapper(LessonRemoteModelMapper()))
    private lateinit var akwukwoSubjectsRepoImpl: AkwukwoSubjectsRemoteRepositoryImpl



    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        akwukwoSubjectsRepoImpl = AkwukwoSubjectsRemoteRepositoryImpl(service, localRepository, mapper)
    }



    @Test
    fun `verify that fetchSubjects is returned when called`() = runBlockingTest {
        val apiRespose = RemoteDataGenerator.generateApiResponse()
        stubApiResponse(apiRespose)
        val subjects = akwukwoSubjectsRepoImpl.fetchSubjects()

        Truth.assertThat(subjects)
            .isNotEmpty()
    }


    private fun stubApiResponse(apiResponse: ApiResponse) {
        coEvery { service.fetchContent() } returns apiResponse
        coEvery { localRepository.saveSubjects(any()) } returns listOf()
    }


}