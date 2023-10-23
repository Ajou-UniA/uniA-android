package com.ajouunia.core.domain.repository

import com.ajouunia.core.domain.entity.TaskEntity

interface TaskRepository {

    suspend fun createTask(
        entity: TaskEntity
    ): Unit?

    suspend fun modifyTask(
        entity: TaskEntity
    ): Unit?

    suspend fun deleteTask(
        taskId: Long
    ): Unit?

    suspend fun fetchRemoteUserTaskList(): List<TaskEntity>?

    suspend fun fetchRemoteUserTaskSortedList(): List<TaskEntity>?

}