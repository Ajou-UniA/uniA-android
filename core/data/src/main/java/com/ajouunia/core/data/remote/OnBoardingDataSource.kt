package com.ajouunia.core.data.remote

import com.ajouunia.core.data.model.response.CheckEmailResponse

interface OnBoardingDataSource {

    suspend fun checkEmail(userEmail: String): CheckEmailResponse?

}