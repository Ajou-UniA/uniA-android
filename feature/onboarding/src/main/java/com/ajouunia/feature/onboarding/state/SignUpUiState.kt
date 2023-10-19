package com.ajouunia.feature.onboarding.state

sealed class SignUpUiState(
    open val infoState: SignUpInfoState = SignUpInfoState()
) {
    object Init : SignUpUiState()

    data class Loading(
        override val infoState: SignUpInfoState = SignUpInfoState()
    ) : SignUpUiState(infoState)

    data class UpdateInfo(
        override val infoState: SignUpInfoState = SignUpInfoState()
    ) : SignUpUiState(infoState)

    data class DepartmentDialog(
        override val infoState: SignUpInfoState = SignUpInfoState()
    ) : SignUpUiState(infoState)

    data class Success(
        override val infoState: SignUpInfoState = SignUpInfoState()
    ) : SignUpUiState(infoState)

    data class Error(
        override val infoState: SignUpInfoState = SignUpInfoState(),
        val exception: Throwable? = null
    ) : SignUpUiState(infoState)
}
