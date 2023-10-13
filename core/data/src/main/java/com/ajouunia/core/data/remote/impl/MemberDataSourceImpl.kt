package com.ajouunia.core.data.remote.impl

import com.ajouunia.core.data.model.response.SignInResponse
import com.ajouunia.core.data.remote.MemberDataSource
import com.ajouunia.core.data.service.MemberService
import com.ajouunia.core.data.utils.safeAPICall
import javax.inject.Inject

class MemberDataSourceImpl
@Inject
constructor(
    private val service: MemberService
) : MemberDataSource {
    override suspend fun signIn(
        email: String,
        password: String
    ): SignInResponse? = safeAPICall {
        service.signIn(
            partMap = mapOf(
                "loginId" to email,
                "password" to password
            )
        )
    }.body

    override suspend fun findMemberByMemberId(idToken: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun modifyMemberInfoByMemberId(idToken: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMemberInfoByMemberId(idToken: Long) {
        TODO("Not yet implemented")
    }
}