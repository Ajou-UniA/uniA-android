package com.ajouunia.core.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
//@Inject
//constructor(
//    private val localUserDataSource: LocalUserDataSource
//) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
        var request = request()


//        val idToken = runBlocking {
//            localUserDataSource.fetchIdToken().first()
//        }

//        request = request.newBuilder()
//            .addHeader(
//                name = "token",
//                value = idToken
//            )
//            .build()

        proceed(request)
    }
}
