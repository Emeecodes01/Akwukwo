package com.mobigods.remote.testutils

import com.mobigods.remote.models.*
import konveyor.base.randomBuild

object RemoteDataGenerator {

    fun <T> generateListOf(count: Int, action: () -> T): List<T> {
        return mutableListOf<T>().apply {
            repeat(count) {
                add(action.invoke())
            }
        }
    }


    fun generateApiResponse(): ApiResponse {
        return ApiResponse(
            SubjectData(
                randomBuild(), randomBuild(),
                generateListOf(2) { getSubjectRemoteModel() }
            )
        )
    }


    private fun getSubjectRemoteModel(): SubjectRemoteModel {
        return SubjectRemoteModel(generateListOf(3) { chapter() }, randomBuild(), randomBuild(), randomBuild())
    }

    private fun chapter(): ChapterRemoteModel {
        return ChapterRemoteModel(
            randomBuild(),
            generateListOf(2) { lesson() },
            randomBuild()
        )
    }

    private fun lesson(): LessonRemoteModel {
        return LessonRemoteModel(
            randomBuild(), randomBuild(), randomBuild(),
            randomBuild(), randomBuild(), randomBuild()
        )
    }

}