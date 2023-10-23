package com.ajouunia.core.data.repository

import com.ajouunia.core.data.local.LocalUserDataSource
import com.ajouunia.core.data.mapper.toEntity
import com.ajouunia.core.data.remote.TaskDataSource
import com.ajouunia.core.domain.entity.TaskEntity
import com.ajouunia.core.domain.repository.TaskRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class TaskRepositoryImpl
@Inject
constructor(
    private val taskDataSource: TaskDataSource,
    private val localUserDataSource: LocalUserDataSource
) : TaskRepository {

    override suspend fun createTask(entity: TaskEntity): Unit? = taskDataSource.createTask(
        entity = entity
    )

    override suspend fun modifyTask(entity: TaskEntity): Unit? = taskDataSource.modifyTask(entity = entity)

    override suspend fun deleteTask(taskId: Long): Unit? = taskDataSource.deleteTask(taskId = taskId)

    override suspend fun fetchRemoteUserTaskList(): List<TaskEntity>? = taskDataSource.fetchRemoteUserTaskList(
        idToken = fetchIdToken()
    )?.map { it.toEntity() }

    override suspend fun fetchRemoteUserTaskSortedList(): List<TaskEntity>? = taskDataSource.fetchRemoteUserTaskSortedList(
        idToken = fetchIdToken()
    )?.map { it.toEntity() }


    private suspend fun fetchIdToken(): Long = when (val idToken = localUserDataSource.fetchIdToken().first()) {
        -1L -> throw NullPointerException()
        else -> idToken
    }

}