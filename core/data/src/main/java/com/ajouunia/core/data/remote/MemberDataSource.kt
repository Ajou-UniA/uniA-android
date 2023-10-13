package com.ajouunia.core.data.remote

import com.ajouunia.core.data.model.response.SignInResponse

interface MemberDataSource {

    suspend fun signIn(
        email: String,
        password: String
    ): SignInResponse?

    suspend fun findMemberByMemberId(
        idToken: Long
    )

    suspend fun modifyMemberInfoByMemberId(
        idToken: Long
    )

    suspend fun deleteMemberInfoByMemberId(
        idToken: Long
    )

}