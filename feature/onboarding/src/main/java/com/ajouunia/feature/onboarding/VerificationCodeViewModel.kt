package com.ajouunia.feature.onboarding

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajouunia.feature.onboarding.state.VerificationCodeUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerificationCodeViewModel
@Inject
constructor(

) : ViewModel() {
    private val _uiState = MutableLiveData<VerificationCodeUIState>(VerificationCodeUIState.Init)
    val uiState: LiveData<VerificationCodeUIState>
        get() = _uiState

    fun changeInputCode(code: String) {
        if (code.isDigitsOnly()) {
            _uiState.value = VerificationCodeUIState.UpdateInfo(code)
        }
    }

    fun submitCode() {
        val code = _uiState.value?.code ?: ""

        if (!code.isDigitsOnly() || code.length != 4) {
            return
        }

        _uiState.value = VerificationCodeUIState.Loading(code)
        remoteSubmitCode(code)
    }

    private fun remoteSubmitCode(code: String) = viewModelScope.launch {

    }


}