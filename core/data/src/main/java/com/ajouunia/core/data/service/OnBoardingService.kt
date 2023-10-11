package com.ajouunia.core.data.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface OnBoardingService {

    @GET("/api/v1/email-check/{memberEmail}")
    suspend fun checkEmail(
        @Path("memberEmail") userEmail: String
    ) : Response<String>

}