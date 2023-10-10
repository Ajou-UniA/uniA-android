package com.ajouunia.feature.onboarding.state

sealed class AgreementServiceUIState(
    open val acceptTermsOfUse: Boolean = false,
    open val acceptPrivacyPolicy: Boolean = false
) {
    object Init : AgreementServiceUIState()
    data class UpdateInfo(
        override val acceptTermsOfUse: Boolean,
        override val acceptPrivacyPolicy: Boolean
    ) : AgreementServiceUIState(
        acceptTermsOfUse = acceptTermsOfUse,
        acceptPrivacyPolicy = acceptPrivacyPolicy
    )
}
