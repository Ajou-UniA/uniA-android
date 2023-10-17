package com.ajouunia.core.domain.usecase

import com.ajouunia.core.domain.repository.OnBoardingRepository
import com.ajouunia.core.domain.util.runSuspendCatching
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SendVerificationCodeUseCase
@Inject
constructor(
    private val repository: OnBoardingRepository
) {

    suspend operator fun invoke(userEmail: String): Result<Unit> = runSuspendCatching {
        repository.sendVerificationCode(userEmail)
    }

}