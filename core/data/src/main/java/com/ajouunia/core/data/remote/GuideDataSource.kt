package com.ajouunia.core.data.remote

import com.ajouunia.core.data.model.response.GetGuideContentListByTopicIndexResponse
import com.ajouunia.core.data.model.response.GetGuideTitleListByTopicIndexResponse

interface GuideDataSource {

    suspend fun getGuideTitleListByTopicIndex(
        index: Int
    ): List<GetGuideTitleListByTopicIndexResponse>?

    suspend fun getGuideContentListByTopicIndex(
        index: Int
    ): List<GetGuideContentListByTopicIndexResponse>?

}