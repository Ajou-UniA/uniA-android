package com.ajouunia.feature.onboarding.model

sealed class SignInUIState(
    open val id: String = "",
    open val password: String = "",
    open val rememberSign: Boolean = false
) {
    object Init : SignInUIState()
    data class Loading(
        override val id: String,
        override val password: String,
        override val rememberSign: Boolean
    ) : SignInUIState(
        id = id,
        password = password
    )
    data class UpdateInfo(
        override val id: String,
        override val password: String,
        override val rememberSign: Boolean
    ) : SignInUIState(
        id = id,
        password = password
    )
    data class FailSignIn(
        override val id: String,
        override val password: String,
        override val rememberSign: Boolean,
        val error: Throwable? = null
    ) : SignInUIState(
        id = id,
        password = password
    )
    data class MoveMain(
        override val id: String = "",
        override val password: String = "",
        override val rememberSign: Boolean
    ) : SignInUIState(
        id = id,
        password = password
    )
}