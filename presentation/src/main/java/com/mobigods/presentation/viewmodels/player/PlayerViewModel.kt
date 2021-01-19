package com.mobigods.presentation.viewmodels.player

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobigods.domain.interactors.recent.SaveRecentLessonUseCase
import com.mobigods.presentation.mappers.RecentLessonModelMapper
import com.mobigods.presentation.models.RecentLessonModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlayerViewModel @Inject constructor (
    private val saveRecentLessonsUseCase: SaveRecentLessonUseCase,
    private val recentLessonModelMapper: RecentLessonModelMapper
): ViewModel() {

    fun saveRecentLesson(lesson: RecentLessonModel) {
        val params = SaveRecentLessonUseCase.Parameter(
            id = lesson.id,
            chapterName = lesson.chapterName,
            watchedDuration = lesson.watchedDuration,
            chapter_id = lesson.lesson.chapter_id,
            icon = lesson.lesson.icon,
            lesson_id = lesson.lesson.id,
            media_url = lesson.lesson.media_url,
            name = lesson.lesson.name,
            subject_id = lesson.lesson.subject_id
        )


        val job = viewModelScope.launch {
            saveRecentLessonsUseCase.invoke(params)
        }

        job.invokeOnCompletion {
            if (it != null) {
                //save successfully
                Log.d(PlayerViewModel::class.simpleName, "Saved successful")
            }
        }
    }
}