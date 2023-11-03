package com.ajouunia.feature.onboarding.vm

import androidx.lifecycle.ViewModel
import com.ajouunia.feature.onboarding.model.AgreementServiceUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class AgreementServiceViewModel
@Inject
constructor(

) : ViewModel() {
    private val _uiState = MutableStateFlow<AgreementServiceUIState>(AgreementServiceUIState.Init)
    val uiState: StateFlow<AgreementServiceUIState>
        get() = _uiState

    fun changeInputTermsOfUse() {
        val state = _uiState.value

        _uiState.value = AgreementServiceUIState.UpdateInfo(
            acceptTermsOfUse = !state.acceptTermsOfUse,
            acceptPrivacyPolicy = state.acceptPrivacyPolicy
        )
    }

    fun changeInputPrivacyPolicy() {
        val state = _uiState.value

        _uiState.value = AgreementServiceUIState.UpdateInfo(
            acceptTermsOfUse = state.acceptTermsOfUse,
            acceptPrivacyPolicy = !state.acceptPrivacyPolicy
        )
    }

}