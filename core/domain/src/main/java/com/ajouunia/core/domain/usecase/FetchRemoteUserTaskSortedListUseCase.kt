package com.ajouunia.core.domain.usecase

import com.ajouunia.core.domain.entity.TaskEntity
import com.ajouunia.core.domain.repository.TaskRepository
import com.ajouunia.core.domain.util.runSuspendCatching
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FetchRemoteUserTaskSortedListUseCase
@Inject
constructor(
    private val repository: TaskRepository
) {

    suspend operator fun invoke(): Result<List<TaskEntity>> = runSuspendCatching {
        repository.fetchRemoteUserTaskSortedList() ?: throw NullPointerException()
    }

}