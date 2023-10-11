package com.ajouunia.core.data.repository

import com.ajouunia.core.data.mapper.toEntity
import com.ajouunia.core.data.remote.OnBoardingDataSource
import com.ajouunia.core.domain.entity.BaseConditionEntity
import com.ajouunia.core.domain.entity.TestEntity
import com.ajouunia.core.domain.repository.OnBoardingRepository
import javax.inject.Inject

class OnBoardingRepositoryImpl
@Inject
constructor(
    private val onBoardingDataSource: OnBoardingDataSource
) : OnBoardingRepository {
    override suspend fun checkEmail(userEmail: String): BaseConditionEntity? = onBoardingDataSource.checkEmail(userEmail)?.toEntity()

}