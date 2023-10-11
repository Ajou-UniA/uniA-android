package com.ajouunia.core.data.remote

import com.ajouunia.core.data.model.response.CheckEmailResponse
import com.ajouunia.core.data.service.OnBoardingService
import com.ajouunia.core.data.utils.safeAPICall
import javax.inject.Inject

class OnBoardingDataSourceImpl
@Inject
constructor(
    private val service: OnBoardingService
) : OnBoardingDataSource {
    override suspend fun checkEmail(userEmail: String): CheckEmailResponse? = safeAPICall {
        service.checkEmail(userEmail = userEmail)
    }.let { apiResult ->
        return@let apiResult.body?.let { CheckEmailResponse(it) }
    }


}