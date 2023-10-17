package com.ajouunia.core.domain.usecase

import com.ajouunia.core.domain.repository.OnBoardingRepository
import com.ajouunia.core.domain.util.runSuspendCatching
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IsVerifyCodeUseCase
@Inject
constructor(
    private val repository: OnBoardingRepository
) {

    suspend operator fun invoke(params: Params): Result<Unit> = runSuspendCatching {
        repository.isVerifyCode(
            userEmail = params.userEmail,
            code = params.code
        ) ?: throw NullPointerException()
    }

    data class Params(
        val userEmail: String,
        val code: String
    )
}
