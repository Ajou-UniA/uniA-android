package com.ajouunia.core.data.model.response

import com.google.gson.annotations.SerializedName

data class GetGuideTitleListByTopicIndexResponse(
    @SerializedName("indexs")
    val index: Int,
    @SerializedName("titles")
    val topicTitle: String
)
