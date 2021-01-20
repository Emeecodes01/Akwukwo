package com.mobigods.cache.db.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.google.common.truth.Truth.*
import com.mobigods.cache.db.AkwukwoDatabase
import com.mobigods.cache.testUtils.CacheDataGenerator
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecentLessonDaoTest {
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
    fun verify_that_save_recent_lesson_works() = runBlocking {
        val recentCachedLesson = CacheDataGenerator.generateRecentCacheLessonModel()
        val id = recentLessonDao.saveRecentLesson(recentCachedLesson)

        assertThat(id)
            .isGreaterThan(0)
    }


    @Test
    fun verity_that_getRecentLessons_returns_result() = runBlocking {
        val recentCachedLesson = CacheDataGenerator.generateRecentCacheLessonModel()
        recentLessonDao.saveRecentLesson(recentCachedLesson)
        val allRecent = recentLessonDao.getRecentLessons()

        assertThat(allRecent.first())
            .isNotEmpty()

    }


}