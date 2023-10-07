package com.ajouunia.core.data.model

internal data class ExceptionWrapper(
    val statusCode: Int? = null,
    override val message: String? = null,
    override val cause: Throwable? = null
) : Exception(message, cause)
