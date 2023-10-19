package com.ajouunia.feature.onboarding.state

sealed class ConfirmEmailUIState(
    open val email: String
) {
    object Init : ConfirmEmailUIState(email = "")
    data class Loading(
        override val email: String
    ) : ConfirmEmailUIState(email = email)
    data class UpdateInfo(
        override val email: String
    ) : ConfirmEmailUIState(email = email)
    data class Success(
        override val email: String
    ) : ConfirmEmailUIState(email = email)
    data class Error(
        override val email: String,
        val error: Throwable? = null
    ) : ConfirmEmailUIState(email = email)
}
