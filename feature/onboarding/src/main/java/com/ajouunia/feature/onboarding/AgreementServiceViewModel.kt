package com.ajouunia.feature.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ajouunia.feature.onboarding.state.AgreementServiceUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AgreementServiceViewModel
@Inject
constructor(

) : ViewModel() {
    private val _uiState = MutableLiveData<AgreementServiceUIState>(AgreementServiceUIState.Init)
    val uiState: LiveData<AgreementServiceUIState>
        get() = _uiState

}