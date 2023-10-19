package com.ajouunia.core.data.model.request

import com.google.gson.annotations.SerializedName

data class IsVerifyCodeRequest(
    @SerializedName("email")
    val userEmail: String,
    @SerializedName("verificationCode")
    val code: String
)
