package com.ajouunia.core.domain.usecase

import com.ajouunia.core.domain.entity.TaskEntity
import com.ajouunia.core.domain.repository.TaskRepository
import com.ajouunia.core.domain.util.runSuspendCatching
import org.threeten.bp.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ModifyTaskUseCase
@Inject
constructor(
    private val repository: TaskRepository
) {

    suspend operator fun invoke(params: Params): Result<Unit> = runSuspendCatching {
        repository.modifyTask(
            entity = TaskEntity(
                taskId = params.taskId,
                deadLine = params.deadLine,
                courseName = params.courseName,
                taskName = params.taskName
            )
        ) ?: throw NullPointerException()
    }

    data class Params(
        val taskId: Long,
        val deadLine: LocalDateTime,
        val courseName: String,
        val taskName: String
    )
}