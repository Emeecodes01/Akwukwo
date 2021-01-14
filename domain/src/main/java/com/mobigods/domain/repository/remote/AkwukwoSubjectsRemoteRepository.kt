package com.mobigods.domain.repository.remote

import com.mobigods.domain.models.Subject

interface AkwukwoSubjectsRemoteRepository {
    suspend fun fetchSubjects(): List<Subject>
}