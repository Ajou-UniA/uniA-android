package com.ajouunia.feature.onboarding.model

sealed class VerificationCodeUIState(
    open val code: String = ""
) {
    object Init : VerificationCodeUIState()
    data class Loading(
        override val code: String
    ) : VerificationCodeUIState(code)
    data class Resend(
        override val code: String
    ) : VerificationCodeUIState(code)
    data class UpdateInfo(
        override val code: String
    ) : VerificationCodeUIState(code)
    data class Success(
        override val code: String
    ) : VerificationCodeUIState(code)
    data class Error(
        override val code: String,
        val exception: Throwable?
    ) : VerificationCodeUIState(code)
}
