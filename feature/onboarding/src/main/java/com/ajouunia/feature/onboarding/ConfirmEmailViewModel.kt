package com.ajouunia.feature.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ajouunia.feature.onboarding.state.ConfirmEmailUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ConfirmEmailViewModel
@Inject
constructor(

) : ViewModel() {
    private val _uiState = MutableLiveData<ConfirmEmailUIState>(ConfirmEmailUIState.Init)
    val uiState: LiveData<ConfirmEmailUIState>
        get() = _uiState

}