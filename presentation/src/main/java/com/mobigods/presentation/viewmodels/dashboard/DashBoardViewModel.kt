package com.mobigods.presentation.viewmodels.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobigods.core.utils.states.AkwukwoResource
import com.mobigods.domain.interactors.subjects.GetSubjectsLocalUseCase
import com.mobigods.domain.interactors.subjects.GetSubjectsRemoteUseCase
import com.mobigods.domain.interactors.subjects.LastFetchedUseCase
import com.mobigods.presentation.mappers.SubjectModelMapper
import com.mobigods.presentation.models.SubjectModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class DashBoardViewModel @Inject constructor(
    private val getSubjectsRemoteUseCase: GetSubjectsRemoteUseCase,
    private val getSubjectsLocalUseCase: GetSubjectsLocalUseCase,
    private val lastFetchedUseCase: LastFetchedUseCase,
    private val subjectModelMapper: SubjectModelMapper
): ViewModel() {

    private val _subjectsRemote: MutableLiveData<AkwukwoResource<List<SubjectModel>>> = MutableLiveData()
    val subjectRemote: LiveData<AkwukwoResource<List<SubjectModel>>> = _subjectsRemote

    private val _subjects: MutableLiveData<AkwukwoResource<List<SubjectModel>>> = MutableLiveData()
    val subject: LiveData<AkwukwoResource<List<SubjectModel>>> = _subjects

    private val subjectExecptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
        _subjectsRemote.value = AkwukwoResource.Error(throwable.message)
    }


    fun getSubjects() {
        val lastFetchedTimeMills = lastFetchedUseCase.execute()
        getSubjectsLocal()
        if (System.currentTimeMillis() - lastFetchedTimeMills > 60*60*1000) {
            getSubjectsRemote()
        }
    }


    private fun getSubjectsLocal() {
        viewModelScope.launch {
            val subjects = getSubjectsLocalUseCase.execute()
            subjects.collect { subjectList->
                _subjects.value = AkwukwoResource.Success(subjectList.map { subjectModelMapper.mapTo(it) })
            }
        }
    }


    private fun getSubjectsRemote() {
        _subjectsRemote.value = AkwukwoResource.Loading()
        val job = viewModelScope.launch(subjectExecptionHandler) { getSubjectsRemoteUseCase.invoke() }

        job.invokeOnCompletion {
            if (it == null){
                completed()
            }
        }
    }


    private fun completed() {
        _subjectsRemote.value = AkwukwoResource.Success(emptyList())//This is already handled using offline first approach
    }


}