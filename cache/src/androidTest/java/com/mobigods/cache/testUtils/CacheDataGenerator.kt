package com.mobigods.cache.testUtils

import com.mobigods.cache.models.ChapterCacheModel
import com.mobigods.cache.models.LessonCacheModel
import com.mobigods.cache.models.RecentLessonCacheModel
import com.mobigods.cache.models.SubjectCacheModel
import konveyor.base.randomBuild

object CacheDataGenerator {

    fun <T> generateListOf(count: Int, action: () -> T): List<T> {
        return mutableListOf<T>().apply {
            repeat(count) {
                add(action.invoke())
            }
        }
    }


    fun generateSubjectCacheModel(): SubjectCacheModel {
        return SubjectCacheModel(
            generateListOf(2) { generateChaptersCacheModel()},
            randomBuild(), randomBuild(), randomBuild()
        )
    }


    fun generateChaptersCacheModel(): ChapterCacheModel {
        return ChapterCacheModel(
            randomBuild(),
            generateListOf(2) { generateLessonsCacheModel()},
            randomBuild()
        )
    }


    fun generateLessonsCacheModel(): LessonCacheModel {
        return LessonCacheModel(
            randomBuild(), randomBuild(), randomBuild(),
            randomBuild(), randomBuild(), randomBuild()
        )
    }

    fun generateRecentCacheLessonModel(): RecentLessonCacheModel {
        return RecentLessonCacheModel(
            randomBuild(), randomBuild(),
            randomBuild(), generateLessonsCacheModel()
        )
    }


}