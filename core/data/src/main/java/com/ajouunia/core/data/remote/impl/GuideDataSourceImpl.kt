package com.ajouunia.core.data.remote.impl

import com.ajouunia.core.data.model.response.GetGuideContentListByTopicIndexResponse
import com.ajouunia.core.data.model.response.GetGuideTitleListByTopicIndexResponse
import com.ajouunia.core.data.remote.GuideDataSource
import com.ajouunia.core.data.service.GuideService
import com.ajouunia.core.data.utils.safeAPICall
import javax.inject.Inject

class GuideDataSourceImpl
@Inject
constructor(
    private val service: GuideService
) : GuideDataSource {

    override suspend fun getGuideTitleListByTopicIndex(index: Int): List<GetGuideTitleListByTopicIndexResponse>? = safeAPICall {
        service.getGuideTitleListByTopicIndex(index)
    }.body

    override suspend fun getGuideContentListByTopicIndex(index: Int): List<GetGuideContentListByTopicIndexResponse>? = safeAPICall {
        service.getGuideContentListByTopicIndex(index)
    }.body

}