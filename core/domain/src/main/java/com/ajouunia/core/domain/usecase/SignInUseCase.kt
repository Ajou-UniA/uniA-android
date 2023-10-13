package com.ajouunia.core.domain.usecase

import com.ajouunia.core.domain.entity.BaseConditionEntity
import com.ajouunia.core.domain.repository.OnBoardingRepository
import com.ajouunia.core.domain.util.runSuspendCatching
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SignInUseCase
@Inject
constructor(
    private val repository: OnBoardingRepository
) {

    suspend operator fun invoke(params: Params): Result<BaseConditionEntity> = runSuspendCatching {
        repository.signIn(
            userEmail = params.userEmail,
            password = params.password
        ) ?: throw NullPointerException()
    }

    data class Params(
        val userEmail: String,
        val password: String
    )
}
