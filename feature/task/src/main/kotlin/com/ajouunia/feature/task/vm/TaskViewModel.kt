package com.ajouunia.feature.task.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajouunia.core.domain.usecase.FetchRemoteUserTaskListUseCase
import com.ajouunia.feature.task.model.TaskDataState
import com.ajouunia.feature.task.model.TaskUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.threeten.bp.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class TaskViewModel
@Inject
constructor(
    private val fetchRemoteUserTaskListUseCase: FetchRemoteUserTaskListUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<TaskUIState>(TaskUIState.Init)
    val uiState: StateFlow<TaskUIState>
        get() = _uiState

    fun createState() {
        val state = _uiState.value

        when (state) {
            is TaskUIState.CreateDialog,
            is TaskUIState.EditDialog,
            is TaskUIState.Loading -> return
            else -> Unit
        }

        _uiState.value = TaskUIState.CreateDialog(
            taskList = state.taskList,
            taskState = TaskDataState()
        )
    }

    fun changeInputDate(deadline: LocalDateTime, isCreateMode: Boolean) {
        val state = _uiState.value

        when (state) {
            is TaskUIState.CreateDialog,
            is TaskUIState.EditDialog -> Unit
            else -> return
        }

        _uiState.value = when (isCreateMode) {
            true -> (state as TaskUIState.CreateDialog).let {
                TaskUIState.CreateDialog(
                    taskList = state.taskList,
                    taskState = state.taskState.copy(deadLine = deadline)
                )
            }
            false -> (state as TaskUIState.EditDialog).let {
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
        val state = _uiState.value

        when (state) {
            is TaskUIState.CreateDialog,
            is TaskUIState.EditDialog -> Unit
            else -> return
        }

        _uiState.value = when (isCreateMode) {
            true -> (state as TaskUIState.CreateDialog).let {
                val deadline = state.taskState.deadLine
                    .withHour(hour)
                    .withMinute(minute)

                TaskUIState.CreateDialog(
                    taskList = state.taskList,
                    taskState = state.taskState.copy(deadLine = deadline)
                )
            }
            false -> (state as TaskUIState.EditDialog).let {
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
            _uiState.emit(TaskUIState.UpdateInfo(it))
        }.onFailure {
            _uiState.emit(TaskUIState.Error(emptyList(), it))
        }
    }

}