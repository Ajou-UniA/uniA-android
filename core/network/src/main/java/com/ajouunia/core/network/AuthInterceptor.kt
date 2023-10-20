package com.ajouunia.core.network

import com.ajouunia.core.data.local.LocalUserDataSource
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor
@Inject
constructor(
    private val localUserDataSource: LocalUserDataSource
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
        var request = request()


        val idToken = runBlocking {
            localUserDataSource.fetchIdToken().first()
        }

        if (idToken != -1L) {
            request = request.newBuilder()
                .addHeader(
                    name = "token",
                    value = idToken.toString()
                )
                .build()
        }

        proceed(request)
    }
}
