package com.ajouunia.feature.home.state

import com.ajouunia.core.domain.entity.TaskEntity

sealed class HomeUIState(
    open val taskList: List<TaskEntity> = emptyList()
) {
    object Init: HomeUIState()

    data class Map(
        override val taskList: List<TaskEntity>
    ) : HomeUIState(taskList)
}