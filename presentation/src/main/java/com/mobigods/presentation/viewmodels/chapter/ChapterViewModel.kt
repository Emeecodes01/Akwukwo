package com.mobigods.presentation.viewmodels.chapter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobigods.domain.interactors.lessons.GetLessonUseCase
import com.mobigods.domain.interactors.lessons.SaveLessonUseCase
import com.mobigods.presentation.mappers.LessonModelMapper
import com.mobigods.presentation.models.LessonModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChapterViewModel @Inject constructor(
    private val saveLessonUseCase: SaveLessonUseCase,
    private val mapper: LessonModelMapper
): ViewModel() {

    fun saveLesson(lessonModel: LessonModel) {
        val job = viewModelScope.launch {
            saveLessonUseCase.invoke(mapper.mapFrom(lessonModel))
        }

        job.invokeOnCompletion {
            if (it != null) {
                Log.i(ChapterViewModel::class.simpleName, "Saved Lesson success")
            }
        }
    }

}