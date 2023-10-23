package com.ajouunia.feature.task.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajouunia.core.domain.usecase.FetchRemoteUserTaskListUseCase
import com.ajouunia.feature.task.state.TaskUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel
@Inject
constructor(
    private val fetchRemoteUserTaskListUseCase: FetchRemoteUserTaskListUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<TaskUIState>()
    val uiState: LiveData<TaskUIState>
        get() = _uiState

    fun fetchTaskList() {
        when (_uiState.value) {
            is TaskUIState.CreateDialog,
            is TaskUIState.EditDialog,
            is TaskUIState.Loading -> return
            else -> Unit
        }

        fetchRemoteTaskList()
    }

    private fun fetchRemoteTaskList() = viewModelScope.launch {
        fetchRemoteUserTaskListUseCase().onSuccess {
            _uiState.postValue(TaskUIState.UpdateInfo(it))
        }.onFailure {
            _uiState.postValue(TaskUIState.Error(emptyList(), it))
        }
    }

}