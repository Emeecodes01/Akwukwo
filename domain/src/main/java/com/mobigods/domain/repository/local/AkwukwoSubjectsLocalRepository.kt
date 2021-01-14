package com.mobigods.domain.repository.local

import com.mobigods.domain.models.Subject

interface AkwukwoSubjectsLocalRepository {
    suspend fun saveSubjects(list: List<Subject>): List<Long>
    suspend fun getAllSubjects(): List<Subject>
}