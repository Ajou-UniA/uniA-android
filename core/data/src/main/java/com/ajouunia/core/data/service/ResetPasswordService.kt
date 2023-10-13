package com.ajouunia.core.data.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ResetPasswordService {

    @GET("resetPassword/{memberEmail}")
    suspend fun findIdTokenByEmail(
        @Path("memberEmail", encoded = true) email: String
    ): Response<Long>

}