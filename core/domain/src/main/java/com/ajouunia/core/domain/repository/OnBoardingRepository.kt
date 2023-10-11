package com.ajouunia.core.domain.repository

import com.ajouunia.core.domain.entity.BaseConditionEntity

interface OnBoardingRepository {

    suspend fun checkEmail(userEmail: String): BaseConditionEntity?

}