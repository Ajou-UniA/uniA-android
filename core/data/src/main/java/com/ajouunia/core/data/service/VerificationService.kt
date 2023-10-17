package com.ajouunia.core.data.service

import com.ajouunia.core.data.model.request.IsVerifyCodeRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface VerificationService {
    @POST("verify")
    suspend fun isVerifyCode(
        @Body request: IsVerifyCodeRequest
    ): Response<Unit>

    @GET("verify/{memberEmail}")
    suspend fun sendVerificationCode(
        @Path("memberEmail") userEmail: String
    ): Response<Unit>

}