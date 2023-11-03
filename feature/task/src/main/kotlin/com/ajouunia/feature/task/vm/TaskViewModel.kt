package com.ajouunia.feature.task.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajouunia.core.domain.usecase.FetchRemoteUserTaskListUseCase
import com.ajouunia.feature.task.state.TaskState
import com.ajouunia.feature.task.state.TaskUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.threeten.bp.LocalDateTime
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

    fun createState() {
        val state = _uiState.value ?: return

        when (state) {
            is TaskUIState.CreateDialog,
            is TaskUIState.EditDialog,
            is TaskUIState.Loading -> return
            else -> Unit
        }

        _uiState.value = TaskUIState.CreateDialog(
            taskList = state.taskList,
            taskState = TaskState()
        )
    }

    fun changeInputDate(deadline: LocalDateTime, isCreateMode: Boolean) {
        val state = _uiState.value ?: return

        when (state) {
            is TaskUIState.CreateDialog,
            is TaskUIState.EditDialog -> Unit
            else -> return
        }

        _uiState.value = when (isCreateMode) {
            true -> (state as? TaskUIState.CreateDialog)?.let {
                TaskUIState.CreateDialog(
                    taskList = state.taskList,
                    taskState = state.taskState.copy(deadLine = deadline)
                )
            }
            false -> (state as? TaskUIState.EditDialog)?.let {
                TaskUIState.EditDialog(
                    taskList = state.taskList,
                    taskState = state.taskState.copy(deadLine = deadline)
                )
            }
        }
    }

    fun changeInputTime(
        hour: Int,
        minute: Int,
        isCreateMode: Boolean
    ) {
        val state = _uiState.value ?: return

        when (state) {
            is TaskUIState.CreateDialog,
            is TaskUIState.EditDialog -> Unit
            else -> return
        }

        _uiState.value = when (isCreateMode) {
            true -> (state as? TaskUIState.CreateDialog)?.let {
                val deadline = state.taskState.deadLine
                    .withHour(hour)
                    .withMinute(minute)

                TaskUIState.CreateDialog(
                    taskList = state.taskList,
                    taskState = state.taskState.copy(deadLine = deadline)
                )
            }
            false -> (state as? TaskUIState.EditDialog)?.let {
                val deadline = state.taskState.deadLine
                    .withHour(hour)
                    .withMinute(minute)

                TaskUIState.EditDialog(
                    taskList = state.taskList,
                    taskState = state.taskState.copy(deadLine = deadline)
                )
            }
        }
    }

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