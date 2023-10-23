package com.ajouunia.core.data.remote

import com.ajouunia.core.data.model.response.FetchRemoteUserTaskListResponse
import com.ajouunia.core.data.model.response.FetchRemoteUserTaskSortedListResponse
import com.ajouunia.core.domain.entity.TaskEntity

interface TaskDataSource {

    suspend fun createTask(
        entity: TaskEntity
    ): Unit?

    suspend fun modifyTask(
        entity: TaskEntity
    ): Unit?

    suspend fun deleteTask(
        taskId: Long
    ): Unit?

    suspend fun fetchRemoteUserTaskList(
        idToken: Long
    ): List<FetchRemoteUserTaskListResponse>?

    suspend fun fetchRemoteUserTaskSortedList(
        idToken: Long
    ): List<FetchRemoteUserTaskSortedListResponse>?

}