package com.ajouunia.core.data.model.response

import com.google.gson.annotations.SerializedName

data class GetGuideContentListByTopicIndexResponse(
    @SerializedName("indexs")
    val index: Int,
    @SerializedName("contents")
    val topicContent: String
)
