package com.ajouunia.core.data.model.request

import com.google.gson.annotations.SerializedName

data class CreateTaskRequest(
    @SerializedName("assignmentId")
    val taskId: Long,
    @SerializedName("deadline")
    val deadLine: String,
    @SerializedName("lectureName")
    val courseName: String,
    @SerializedName("name")
    val taskName: String
)