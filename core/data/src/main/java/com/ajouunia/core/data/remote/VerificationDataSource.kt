package com.ajouunia.core.data.remote

interface VerificationDataSource {

    suspend fun isVerifyCode(
        userEmail: String,
        code: String
    ): Unit?

    suspend fun sendVerificationCode(
        userEmail: String
    ): Unit?

}