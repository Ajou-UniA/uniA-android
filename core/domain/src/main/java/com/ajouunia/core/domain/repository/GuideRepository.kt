package com.ajouunia.core.domain.repository

import com.ajouunia.core.domain.entity.GuideEntity

interface GuideRepository {

    suspend fun getGuideList(index: Int) : List<GuideEntity>?

}