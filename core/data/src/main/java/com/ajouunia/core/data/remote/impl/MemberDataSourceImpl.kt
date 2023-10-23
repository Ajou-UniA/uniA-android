package com.ajouunia.core.data.remote.impl

import com.ajouunia.core.data.model.response.SignInResponse
import com.ajouunia.core.data.remote.MemberDataSource
import com.ajouunia.core.data.service.MemberService
import com.ajouunia.core.data.utils.safeAPICall
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
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
            email = email,
            password = password
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