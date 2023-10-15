package com.ajouunia.feature.onboarding.state

sealed class SignInUIState(
    open val email: String = "",
    open val password: String = "",
    open val rememberSign: Boolean = false
) {
    object Init : SignInUIState()
    data class Loading(
        override val email: String,
        override val password: String,
        override val rememberSign: Boolean
    ) : SignInUIState(
        email = email,
        password = password
    )
    data class UpdateInfo(
        override val email: String,
        override val password: String,
        override val rememberSign: Boolean
    ) : SignInUIState(
        email = email,
        password = password
    )
    data class SuccessSignIn(
        override val email: String,
        override val password: String,
        override val rememberSign: Boolean
    ) : SignInUIState(
        email = email,
        password = password
    )
    data class FailSignIn(
        override val email: String,
        override val password: String,
        override val rememberSign: Boolean,
        val error: Throwable? = null
    ) : SignInUIState(
        email = email,
        password = password
    )
    data class MoveMain(
        override val email: String = "",
        override val password: String = "",
        override val rememberSign: Boolean
    ) : SignInUIState(
        email = email,
        password = password
    )
}