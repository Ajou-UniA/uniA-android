package com.ajouunia.core.domain.repository

import com.ajouunia.core.domain.entity.BaseConditionEntity

interface OnBoardingRepository {

    suspend fun signIn(userEmail: String, password: String): BaseConditionEntity?

    suspend fun checkEmail(userEmail: String): BaseConditionEntity?

    suspend fun findIdTokenByEmail(
        email: String
    ): BaseConditionEntity?

}