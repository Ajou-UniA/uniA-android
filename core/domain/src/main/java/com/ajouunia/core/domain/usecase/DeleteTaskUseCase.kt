package com.ajouunia.core.domain.usecase

import com.ajouunia.core.domain.entity.TaskEntity
import com.ajouunia.core.domain.repository.TaskRepository
import com.ajouunia.core.domain.util.runSuspendCatching
import org.threeten.bp.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeleteTaskUseCase
@Inject
constructor(
    private val repository: TaskRepository
) {

    suspend operator fun invoke(taskId: Long): Result<Unit> = runSuspendCatching {
        repository.deleteTask(taskId = taskId) ?: throw NullPointerException()
    }

}