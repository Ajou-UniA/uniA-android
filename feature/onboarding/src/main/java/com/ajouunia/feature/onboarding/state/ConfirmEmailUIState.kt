package com.ajouunia.feature.onboarding.state

sealed class ConfirmEmailUIState(
    open val email: String
) {
    object Init : ConfirmEmailUIState(email = "")
    data class UpdateInfo(
        override val email: String
    ) : ConfirmEmailUIState(email = email)
}
