package com.ajouunia.feature.task.state

import org.threeten.bp.LocalDateTime

data class TaskState(
    val taskId: Long = -1L,
    val deadLine: LocalDateTime = LocalDateTime.now(),
    val courseName: String = "",
    val taskName: String = ""
)
