package com.ajouunia.core.data.remote

import com.ajouunia.core.data.model.response.IsDuplicateEmailResponse


interface SignUpDataSource {

    suspend fun signUpAccount()

    suspend fun isDuplicateEmail(
        userEmail: String
    ): IsDuplicateEmailResponse?

}