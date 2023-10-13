package com.ajouunia.core.data.repository

import com.ajouunia.core.data.local.LocalUserDataSource
import com.ajouunia.core.data.mapper.toEntity
import com.ajouunia.core.data.remote.MemberDataSource
import com.ajouunia.core.data.remote.ResetPasswordDataSource
import com.ajouunia.core.data.remote.SignUpDataSource
import com.ajouunia.core.domain.entity.BaseConditionEntity
import com.ajouunia.core.domain.repository.OnBoardingRepository
import javax.inject.Inject

class OnBoardingRepositoryImpl
@Inject
constructor(
    private val memberDataSource: MemberDataSource,
    private val signUpDataSource: SignUpDataSource,
    private val resetPasswordDataSource: ResetPasswordDataSource,
    private val localUserDataSource: LocalUserDataSource
) : OnBoardingRepository {
    override suspend fun signIn(
        userEmail: String,
        password: String
    ): BaseConditionEntity? = memberDataSource.signIn(
        email = userEmail,
        password = password
    )?.toEntity()

    override suspend fun checkEmail(userEmail: String): BaseConditionEntity? = signUpDataSource.isDuplicateEmail(userEmail)?.toEntity()
    override suspend fun findIdTokenByEmail(email: String): BaseConditionEntity? = when (val value = resetPasswordDataSource.findIdTokenByEmail(email = email)) {
        null -> null
        -1L -> BaseConditionEntity(false)
        else -> {
            localUserDataSource.saveIdToken(idToken = value)
            BaseConditionEntity(true)
        }
    }

}