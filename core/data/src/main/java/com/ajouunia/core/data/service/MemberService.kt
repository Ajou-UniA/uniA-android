package com.ajouunia.core.data.service

import com.ajouunia.core.data.model.response.SignInResponse
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PartMap
import retrofit2.http.Path

interface MemberService {

    @Multipart
    @POST("member/login")
    suspend fun signIn(
//        @Field("loginId", encoded = true) loginId: String,
//        @Field("password") password: String
//        @Body request: RequestBody
        @PartMap partMap: Map<String, String>
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