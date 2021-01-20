package com.mobigods.presentation.viewmodels.player

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobigods.domain.interactors.recent.GetLessonUseCase
import com.mobigods.domain.interactors.recent.UpdateRecentLessonUseCase
import com.mobigods.presentation.models.PlayerData
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class PlayerViewModel @Inject constructor(
    private val updateRecentLessonUseCase: UpdateRecentLessonUseCase,
    private val getLessonUseCase: GetLessonUseCase
) : ViewModel() {

    private val _lessonsLiveData: MutableLiveData<Boolean> = MutableLiveData(false)
    val lessons: LiveData<Boolean> = _lessonsLiveData

    private var job: Job? = null
    private val execptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    private fun generateRandomId(): String {
        return UUID.randomUUID().toString().replace("-", "");
    }


    fun saveRecentLesson(watchedDuration: Long, playerData: PlayerData) {
        job = viewModelScope.launch(execptionHandler) {
            val lesson = getLessonUseCase.invoke(playerData.lessonId)

            val param = UpdateRecentLessonUseCase.Parameter(
                recentId = if (playerData.recentId.isEmpty()) generateRandomId() else playerData.recentId,
                watchedDuration, System.currentTimeMillis(),
                lesson.id, lesson.chapter_id, lesson.subject_id
            )

            updateRecentLessonUseCase.invoke(param)
            _lessonsLiveData.value = true
        }

    }
}