package com.ajouunia.core.data.model.response

import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @SerializedName("result")
    val result: Int
)
