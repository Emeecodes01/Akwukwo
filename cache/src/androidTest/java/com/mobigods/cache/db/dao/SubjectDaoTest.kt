package com.mobigods.cache.db.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.google.common.truth.Truth.*
import com.mobigods.cache.db.AkwukwoDatabase
import com.mobigods.cache.testUtils.CacheDataGenerator
import com.mobigods.cache.testUtils.CacheDataGenerator.generateListOf
import com.mobigods.cache.testUtils.CacheDataGenerator.generateSubjectCacheModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SubjectDaoTest {
    private lateinit var testDb: AkwukwoDatabase

    private lateinit var subjectDao: SubjectDao
    private lateinit var recentLessonDao: RecentLessonDao

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        testDb = Room.inMemoryDatabaseBuilder(
            context, AkwukwoDatabase::class.java).build()

        subjectDao = testDb.subjectDao()
        recentLessonDao = testDb.recentLessonDao()
    }


    @Test
    fun verify_that_saveSubjects_save_a_list_of_subjects() = runBlocking {
        val subjects = generateListOf(2) {generateSubjectCacheModel()}
        val subjectIds = subjectDao.saveSubjects(subjects)

        assertThat(subjectIds)
            .isNotEmpty()
    }


    @Test
    fun verify_that_getAllSubjects_Returns_a_list_of_subjects() = runBlocking {
        subjectDao.saveSubjects(generateListOf(2) {generateSubjectCacheModel()})

        val subjects = subjectDao.getAllSubjects().first()

        assertThat(subjects)
            .isNotEmpty()
    }


}