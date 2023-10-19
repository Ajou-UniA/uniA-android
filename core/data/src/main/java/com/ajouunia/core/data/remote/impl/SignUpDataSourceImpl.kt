package com.ajouunia.core.data.remote.impl

import com.ajouunia.core.data.model.response.IsDuplicateEmailResponse
import com.ajouunia.core.data.remote.SignUpDataSource
import com.ajouunia.core.data.service.SignUpService
import com.ajouunia.core.data.utils.safeAPICall
import javax.inject.Inject

class SignUpDataSourceImpl
@Inject
constructor(
    private val service: SignUpService
) : SignUpDataSource {
    override suspend fun signUpAccount() {
        TODO("Not yet implemented")
    }

    override suspend fun isDuplicateEmail(userEmail: String): IsDuplicateEmailResponse? = safeAPICall {
        service.isDuplicateEmail(
            userEmail = userEmail
        )
    }.let { apiResult ->
        return@let apiResult.body?.let { IsDuplicateEmailResponse(it) }
    }

}