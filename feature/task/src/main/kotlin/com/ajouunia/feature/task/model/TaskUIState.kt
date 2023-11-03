package com.ajouunia.feature.task.model

import com.ajouunia.core.domain.entity.TaskEntity

sealed class TaskUIState(
    open val taskList: List<TaskEntity> = emptyList()
) {
    object Init : TaskUIState()

    data class Loading(
        override val taskList: List<TaskEntity>
    ) : TaskUIState(taskList = taskList)

    data class UpdateInfo(
        override val taskList: List<TaskEntity>
    ) : TaskUIState(taskList = taskList)

    data class CreateDialog(
        override val taskList: List<TaskEntity>,
        val taskState: TaskDataState
    ) : TaskUIState(taskList = taskList)

    data class EditDialog(
        override val taskList: List<TaskEntity>,
        val taskState: TaskDataState
    ) : TaskUIState(taskList = taskList)

    data class Error(
        override val taskList: List<TaskEntity>,
        val error: Throwable? = null
    ) : TaskUIState(taskList = taskList)

}