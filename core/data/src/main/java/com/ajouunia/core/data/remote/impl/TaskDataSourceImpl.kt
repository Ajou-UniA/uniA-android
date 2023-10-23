package com.ajouunia.core.data.remote.impl

import com.ajouunia.core.data.mapper.toCreateModel
import com.ajouunia.core.data.mapper.toModifyModel
import com.ajouunia.core.data.model.response.FetchRemoteUserTaskListResponse
import com.ajouunia.core.data.model.response.FetchRemoteUserTaskSortedListResponse
import com.ajouunia.core.data.remote.TaskDataSource
import com.ajouunia.core.data.service.TaskService
import com.ajouunia.core.data.utils.safeAPICall
import com.ajouunia.core.domain.entity.TaskEntity
import javax.inject.Inject

class TaskDataSourceImpl
@Inject
constructor(
    private val service: TaskService
) : TaskDataSource {

    override suspend fun createTask(entity: TaskEntity): Unit? = safeAPICall {
        service.createTask(
            request = entity.toCreateModel()
        )
    }.body

    override suspend fun modifyTask(entity: TaskEntity): Unit? = safeAPICall {
        service.modifyTask(
            taskId = entity.taskId,
            request = entity.toModifyModel()
        )
    }.body

    override suspend fun deleteTask(taskId: Long): Unit? = safeAPICall {
        service.deleteTask(taskId)
    }.body

    override suspend fun fetchRemoteUserTaskList(idToken: Long): List<FetchRemoteUserTaskListResponse>? = safeAPICall {
        service.fetchRemoteUserTaskList(idToken = idToken)
    }.body

    override suspend fun fetchRemoteUserTaskSortedList(idToken: Long): List<FetchRemoteUserTaskSortedListResponse>? = safeAPICall {
        service.fetchRemoteUserTaskSortedList(idToken = idToken)
    }.body

}