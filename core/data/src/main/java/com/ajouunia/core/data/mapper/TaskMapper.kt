package com.ajouunia.core.data.mapper

import com.ajouunia.core.data.model.request.CreateTaskRequest
import com.ajouunia.core.data.model.request.ModifyTaskRequest
import com.ajouunia.core.data.model.response.FetchRemoteUserTaskListResponse
import com.ajouunia.core.data.model.response.FetchRemoteUserTaskSortedListResponse
import com.ajouunia.core.domain.entity.TaskEntity
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

private val format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")

internal fun TaskEntity.toCreateModel(): CreateTaskRequest = CreateTaskRequest(
    taskId = taskId,
    deadLine = format.format(deadLine),
    courseName = courseName,
    taskName = taskName
)

internal fun TaskEntity.toModifyModel(): ModifyTaskRequest = ModifyTaskRequest(
    taskId = taskId,
    deadLine = format.format(deadLine),
    courseName = courseName,
    taskName = taskName
)

internal fun FetchRemoteUserTaskListResponse.toEntity() = TaskEntity(
    taskId = taskId,
    deadLine = LocalDateTime.parse(deadLine, format),
    courseName = courseName,
    taskName = taskName
)

internal fun FetchRemoteUserTaskSortedListResponse.toEntity() = TaskEntity(
    taskId = taskId,
    deadLine = LocalDateTime.parse(deadLine, format),
    courseName = courseName,
    taskName = taskName
)