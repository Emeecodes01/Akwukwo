package com.mobigods.domain.interactors.subjects.testutils

import com.mobigods.domain.models.Chapter
import com.mobigods.domain.models.Lesson
import com.mobigods.domain.models.RecentLesson
import com.mobigods.domain.models.Subject
import konveyor.base.randomBuild

object DataGenerator {

    fun generateSubjects(count: Int): List<Subject> {
        val subjects: MutableList<Subject> = mutableListOf()
        repeat(count) {
            subjects.add(
                Subject(
                    generateChapters(count),
                    randomBuild(), randomBuild(), randomBuild()
                )
            )
        }
        return subjects
    }


    fun generateChapters(count: Int): List<Chapter> {
        val chapters: MutableList<Chapter> = mutableListOf()
        repeat(count) {
            chapters.add(
                Chapter(
                    randomBuild(),
                    generateLessons(count),
                    randomBuild()
                )
            )
        }
        return chapters
    }


    fun generateLessons(count: Int): List<Lesson> {
        val lessons: MutableList<Lesson> = mutableListOf()
        repeat(count) {
            lessons.add(generateLesson())
        }
        return lessons
    }


    fun generateLesson() =
        Lesson(
            randomBuild(), randomBuild(), randomBuild(),
            randomBuild(), randomBuild(), randomBuild()
        )

    fun generateRecentList(count: Int): List<RecentLesson> {
        return mutableListOf<RecentLesson>().apply {
            repeat(count){
                add(generateRecentLesson())
            }
        }
    }


    fun generateRecentLesson(): RecentLesson {
        return RecentLesson(
            randomBuild(), randomBuild(), randomBuild(),
            generateLesson()
        )
    }

}