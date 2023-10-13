package com.ajouunia.core.data.model.request

import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("loginId")
    val userEmail: String,
    @SerializedName("password")
    val password: String
)