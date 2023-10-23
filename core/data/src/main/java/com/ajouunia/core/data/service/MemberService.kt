package com.ajouunia.core.data.service

import com.ajouunia.core.data.model.response.SignInResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap
import retrofit2.http.Path

interface MemberService {

//    @Multipart
    @FormUrlEncoded
    @POST("member/login")
    suspend fun signIn(
//        @Part("loginId") email: RequestBody,
//        @Part("password") password: RequestBody
        @Field("loginId", encoded = true) email: String,
        @Field("password", encoded = true) password: String
    ): Response<SignInResponse>

    @GET("member/{memberId}")
    suspend fun findMemberByMemberId(
        @Path("memberId") idToken: Long
    )

    @PATCH("member/{memberId}")
    suspend fun modifyMemberInfoByMemberId(
        @Path("memberId") idToken: Long
    )

    @DELETE
    suspend fun deleteMemberInfoByMemberId(
        @Path("memberId") idToken: Long
    )



}