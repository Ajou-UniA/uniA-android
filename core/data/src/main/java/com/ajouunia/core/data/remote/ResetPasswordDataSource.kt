package com.ajouunia.core.data.remote

interface ResetPasswordDataSource {

    suspend fun findIdTokenByEmail(
       email: String
    ): Long?

}