package com.mobigods.presentation.viewmodels.player

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobigods.domain.interactors.lessons.GetLessonUseCase
import com.mobigods.domain.interactors.recent.SaveRecentLessonUseCase
import com.mobigods.domain.interactors.subjects.GetSubjectsLocalUseCase
import com.mobigods.presentation.mappers.RecentLessonModelMapper
import com.mobigods.presentation.models.PlayerData
import com.mobigods.presentation.models.RecentLessonModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class PlayerViewModel @Inject constructor(
    private val saveRecentLessonsUseCase: SaveRecentLessonUseCase,
    private val getLessonUseCase: GetLessonUseCase
) : ViewModel() {

    private fun generateRandomId(): String {
        return UUID.randomUUID().toString().replace("-", "");
    }


    fun saveRecentLesson(watchedDuration: Long, playerData: PlayerData) {
        viewModelScope.launch(CoroutineExceptionHandler { coroutineContext, throwable -> throwable.printStackTrace() }) {
            Log.i(PlayerViewModel::class.simpleName, "called in vm")
            val lesson = getLessonUseCase.invoke(playerData.lessonId)

            Log.i(PlayerViewModel::class.simpleName, lesson.toString())

            val params = SaveRecentLessonUseCase.Parameter (
                id = if (playerData.recentId.isEmpty()) generateRandomId() else playerData.recentId,
                watchedDuration = watchedDuration,
                chapter_id = lesson.chapter_id,
                icon = lesson.icon,
                lesson_id = lesson.id,
                media_url = lesson.media_url,
                name = lesson.name,
                subject_id = lesson.subject_id
            )

            saveRecentLessonsUseCase.invoke(params)
            Log.i(PlayerViewModel::class.simpleName, "Saved recent")
        }
    }
}