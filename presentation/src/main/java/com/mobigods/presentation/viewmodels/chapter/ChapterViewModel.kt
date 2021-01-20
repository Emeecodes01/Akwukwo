package com.mobigods.presentation.viewmodels.chapter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobigods.domain.interactors.recent.SaveRecentLessonUseCase
import com.mobigods.presentation.mappers.LessonModelMapper
import com.mobigods.presentation.models.LessonModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChapterViewModel @Inject constructor(
    private val saveLessonUseCase: SaveRecentLessonUseCase,
    private val mapper: LessonModelMapper
): ViewModel() {

    private val job = Job()

    fun saveLesson(lessonModel: LessonModel) {
        viewModelScope.launch (job){
            val param = SaveRecentLessonUseCase.Parameter(
                lesson_id = lessonModel.id,
                chapter_id = lessonModel.chapter_id,
                icon = lessonModel.icon,
                media_url = lessonModel.media_url,
                name = lessonModel.name,
                subject_id = lessonModel.subject_id
            )
            saveLessonUseCase.invoke(param)
        }

        job.invokeOnCompletion {
            if (it == null) {
                Log.i(ChapterViewModel::class.simpleName, "Lesson saved")
            }
        }
    }


    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }

}