package com.mobigods.domain.repository.local

import com.mobigods.domain.models.Subject
import kotlinx.coroutines.flow.Flow

interface AkwukwoSubjectsLocalRepository {
    suspend fun saveSubjects(list: List<Subject>): List<Long>
    fun getAllSubjects(): Flow<List<Subject>>
    var lastSynced: Long
}