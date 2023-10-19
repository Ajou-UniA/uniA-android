package com.ajouunia.core.data.service

import com.ajouunia.core.data.model.response.GetGuideContentListByTopicIndexResponse
import com.ajouunia.core.data.model.response.GetGuideTitleListByTopicIndexResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GuideService {

    @GET("guide/title/{index}")
    suspend fun getGuideTitleListByTopicIndex(
        @Path("index") index: Int
    ): Response<List<GetGuideTitleListByTopicIndexResponse>>

    @GET("guide/content/{index}")
    suspend fun getGuideContentListByTopicIndex(
        @Path("index") index: Int
    ): Response<List<GetGuideContentListByTopicIndexResponse>>

}