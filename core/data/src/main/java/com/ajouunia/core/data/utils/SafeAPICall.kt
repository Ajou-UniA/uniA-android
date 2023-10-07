package com.ajouunia.core.data.utils

import com.ajouunia.core.data.model.APIResult
import com.ajouunia.core.data.model.ExceptionWrapper
import com.ajouunia.core.data.model.NetworkMessage
import retrofit2.HttpException
import retrofit2.Response
import java.net.UnknownHostException

internal suspend fun <T> safeAPICall(
    request: suspend () -> Response<T>
) : APIResult<T> = try {
    val response = request()

    when (response.isSuccessful) {
        true -> {
            // Success Response
            APIResult(
                headers = response.headers(),
                body = response.body()
            )
        }
        false -> {
            // Fail Response
            val errorBody = response.errorBody()?.string() ?: NetworkMessage.UNKNOWN_ERROR

            val exception = Exception(errorBody)

            throw ExceptionWrapper(
                statusCode = response.code(),
                message = exception.message,
                cause = exception
            )
        }
    }
} catch (exception: ExceptionWrapper) {
    throw exception
} catch (exception: HttpException) {
    // http exception
    throw ExceptionWrapper(
        statusCode = exception.code(),
        message = exception.message,
        cause = exception
    )
} catch (exception: UnknownHostException) {
    // UnknownHost exception cause: not connect network
    throw ExceptionWrapper(
        message = exception.message,
        cause = exception
    )
} catch (exception: Exception) {
    // Unknown exception
    throw ExceptionWrapper(
        message = exception.message,
        cause = exception
    )
}