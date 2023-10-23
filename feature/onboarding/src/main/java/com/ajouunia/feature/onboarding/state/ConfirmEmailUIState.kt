package com.ajouunia.feature.onboarding.state

sealed class ConfirmEmailUIState(
    open val id: String
) {
    object Init : ConfirmEmailUIState(id = "")
    data class Loading(
        override val id: String
    ) : ConfirmEmailUIState(id = id)
    data class UpdateInfo(
        override val id: String
    ) : ConfirmEmailUIState(id = id)
    data class Success(
        override val id: String
    ) : ConfirmEmailUIState(id = id)
    data class Error(
        override val id: String,
        val error: Throwable? = null
    ) : ConfirmEmailUIState(id = id)
}
