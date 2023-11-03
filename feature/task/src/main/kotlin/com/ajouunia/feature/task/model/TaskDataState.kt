package com.ajouunia.feature.task.model

import org.threeten.bp.LocalDateTime

data class TaskDataState(
    val taskId: Long = -1L,
    val deadLine: LocalDateTime = LocalDateTime.now(),
    val courseName: String = "",
    val taskName: String = ""
)
