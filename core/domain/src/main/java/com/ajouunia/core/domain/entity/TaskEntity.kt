package com.ajouunia.core.domain.entity

import org.threeten.bp.LocalDateTime

data class TaskEntity(
    val taskId: Long,
    val deadLine: LocalDateTime,
    val courseName: String,
    val taskName: String
)
