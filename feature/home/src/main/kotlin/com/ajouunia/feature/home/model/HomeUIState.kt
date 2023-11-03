package com.ajouunia.feature.home.model

import com.ajouunia.core.domain.entity.AjouMapGuideEntity
import com.ajouunia.core.domain.entity.TaskEntity

sealed class HomeUIState(
    open val taskList: List<TaskEntity> = emptyList(),
    open val partitions: List<List<AjouMapGuideEntity>> = emptyList()
) {
    object Init: HomeUIState()

    data class UpdateInfo(
        override val taskList: List<TaskEntity>,
        override val partitions: List<List<AjouMapGuideEntity>>
    ) : HomeUIState(
        taskList = taskList,
        partitions = partitions
    )

    data class Map(
        override val taskList: List<TaskEntity>,
        override val partitions: List<List<AjouMapGuideEntity>>
    ) : HomeUIState(
        taskList = taskList,
        partitions = partitions
    )
}