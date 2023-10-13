package com.ajouunia.core.data.remote.impl

import com.ajouunia.core.data.model.request.IsVerifyCodeRequest
import com.ajouunia.core.data.remote.VerificationDataSource
import com.ajouunia.core.data.service.VerificationService
import com.ajouunia.core.data.utils.safeAPICall
import javax.inject.Inject

class VerificationDataSourceImpl
@Inject
constructor(
    private val service: VerificationService
) : VerificationDataSource {
    override suspend fun isVerifyCode(
        userEmail: String,
        code: String
    ): Unit? = safeAPICall {
        service.isVerifyCode(
            request = IsVerifyCodeRequest(
                userEmail = userEmail,
                code = code
            )
        )
    }.body

    override suspend fun sendVerificationCode(userEmail: String) {
        TODO("Not yet implemented")
    }

}