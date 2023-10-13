package com.ajouunia.core.data.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SignUpService {

    @POST("create")
    suspend fun signUpAccount()

    @GET("email-check/{memberEmail}")
    suspend fun isDuplicateEmail(
        @Path("memberEmail") userEmail: String
    ): Response<String>

}