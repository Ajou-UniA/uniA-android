package com.ajouunia.core.data.model.response

import com.google.gson.annotations.SerializedName

data class FetchRemoteUserTaskSortedListResponse(
    @SerializedName("assignmentId")
    val taskId: Long,
    @SerializedName("deadline")
    val deadLine: String,
    @SerializedName("lectureName")
    val courseName: String,
    @SerializedName("name")
    val taskName: String
)
