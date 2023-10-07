package com.ajouunia.core.data.model

import okhttp3.Headers

data class APIResult<T>(
    val headers: Headers,
    val body: T?
)
