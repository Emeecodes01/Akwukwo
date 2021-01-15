package com.mobigods.remote.impl

import com.mobigods.domain.models.Subject
import com.mobigods.domain.repository.local.AkwukwoSubjectsLocalRepository
import com.mobigods.domain.repository.remote.AkwukwoSubjectsRemoteRepository
import com.mobigods.remote.mappers.SubjectRemoteModelMapper
import com.mobigods.remote.services.AkwukwoContentService
import com.mobigods.remote.utils.ErrorExtractor
import javax.inject.Inject

class AkwukwoSubjectsRemoteRepositoryImpl @Inject constructor (
    private val service: AkwukwoContentService,
    private val localRepository: AkwukwoSubjectsLocalRepository,
    private val subjectRemoteModelMapper: SubjectRemoteModelMapper
): AkwukwoSubjectsRemoteRepository {


    override suspend fun fetchSubjects(): List<Subject> {
        try {
            val subjects =  service.fetchContent().subjectData.subjects.map { subjectRemoteModelMapper.mapFrom(it) }
            localRepository.saveSubjects(subjects)
            localRepository.lastSynced = System.currentTimeMillis()
            return subjects
        } catch (e: Exception) {
            val message = ErrorExtractor.getReadableMessage(e)
            throw Exception(message)
        }
    }

}