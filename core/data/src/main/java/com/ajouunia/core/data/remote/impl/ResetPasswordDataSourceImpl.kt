package com.ajouunia.core.data.remote.impl

import com.ajouunia.core.data.remote.ResetPasswordDataSource
import com.ajouunia.core.data.service.ResetPasswordService
import com.ajouunia.core.data.utils.safeAPICall
import javax.inject.Inject

class ResetPasswordDataSourceImpl
@Inject
constructor(
    private val service: ResetPasswordService
) : ResetPasswordDataSource {

    override suspend fun findIdTokenByEmail(email: String): Long? = safeAPICall {
        service.findIdTokenByEmail(email = email)
    }.body

}