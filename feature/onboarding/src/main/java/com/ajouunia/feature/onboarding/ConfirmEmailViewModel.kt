package com.ajouunia.feature.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajouunia.core.domain.usecase.IsDuplicateEmailUseCase
import com.ajouunia.feature.onboarding.state.ConfirmEmailUIState
import com.ajouunia.feature.onboarding.utils.isAjouUnivEmail
import com.ajouunia.feature.onboarding.utils.isEmptyId
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfirmEmailViewModel
@Inject
constructor(
    private val isDuplicateEmailUseCase: IsDuplicateEmailUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<ConfirmEmailUIState>(ConfirmEmailUIState.Init)
    val uiState: LiveData<ConfirmEmailUIState>
        get() = _uiState

    fun changeInputEmail(email: String) {
        if (_uiState.value is ConfirmEmailUIState.Loading) {
            return
        }

        _uiState.value = ConfirmEmailUIState.UpdateInfo(email = email.replace(" ", ""))
    }

    fun submitEmail() {
        val email = _uiState.value?.email ?: return
        if (!email.isAjouUnivEmail() && email.isEmptyId()) {
            return
        }
        _uiState.value = ConfirmEmailUIState.Loading(email = email)
        remoteSubmitEmail(email)
    }

    private fun remoteSubmitEmail(email: String) = viewModelScope.launch {
        isDuplicateEmailUseCase(userEmail = email).onSuccess {
            when (it.result) {
                true -> remoteSendCode(email = email)
                false -> _uiState.postValue(ConfirmEmailUIState.Error(email))
            }
        }.onFailure {
            _uiState.postValue(ConfirmEmailUIState.Error(email))
        }
    }

    private fun remoteSendCode(email: String) {
        // TODO
        _uiState.postValue(ConfirmEmailUIState.Success(email = email))
    }

    fun isValidEmail(): Boolean = _uiState.value?.email?.let {
        it.isAjouUnivEmail() and it.isEmptyId()
    } ?: false

    companion object {
        const val AJOU_UNIV_DEFAULT_EMAIL_FORM = "@ajou.ac.kr"
    }
}