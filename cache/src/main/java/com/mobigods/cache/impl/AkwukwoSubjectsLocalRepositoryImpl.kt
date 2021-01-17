package com.mobigods.cache.impl

import com.mobigods.cache.db.dao.SubjectDao
import com.mobigods.cache.mappers.SubjectCacheModelMapper
import com.mobigods.cache.preference.AkwukwoPreferenceManager
import com.mobigods.cache.preference.IPreferenceManager
import com.mobigods.domain.models.Subject
import com.mobigods.domain.repository.local.AkwukwoSubjectsLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class AkwukwoSubjectsLocalRepositoryImpl @Inject constructor(
    private val subjectDao: SubjectDao,
    private val preferenceManager: IPreferenceManager,
    private val mapper: SubjectCacheModelMapper
) : AkwukwoSubjectsLocalRepository {

    override suspend fun saveSubjects(list: List<Subject>): List<Long> {
        return subjectDao.saveSubjects(list.map { mapper.mapTo(it) })
    }

    override fun getAllSubjects(): Flow<List<Subject>> {
        val subjects = subjectDao.getAllSubjects()
        return subjects.flatMapConcat {
            flowOf(it.map { subjectCacheModel ->
                mapper.mapFrom(subjectCacheModel)
            })
        }
    }


    override var lastSynced: Long
        get() = preferenceManager.lastSynced
        set(value) {
            preferenceManager.lastSynced = value
        }

}