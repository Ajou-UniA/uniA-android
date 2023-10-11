package com.ajouunia.feature.onboarding

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajouunia.core.domain.usecase.CheckEmailUseCase
import com.ajouunia.feature.onboarding.state.ConfirmEmailUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfirmEmailViewModel
@Inject
constructor(
    private val checkEmailUseCase: CheckEmailUseCase
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
        checkEmailUseCase(userEmail = email).onSuccess {
            when (it.result) {
                true -> remoteSendCode(email = email)
                false -> _uiState.postValue(ConfirmEmailUIState.Error(email))
            }
        }.onFailure {
            _uiState.postValue(ConfirmEmailUIState.Error(email))
        }
    }

    private fun remoteSendCode(email: String) {

    }

    fun isValidEmail(): Boolean = _uiState.value?.email?.let {
        it.isAjouUnivEmail() && it.isEmptyId()
    } ?: false

    private fun String.isAjouUnivEmail(): Boolean = this.contains(AJOU_UNIV_DEFAULT_EMAIL_FORM)

    private fun String.isEmptyId(): Boolean = this.split(AJOU_UNIV_DEFAULT_EMAIL_FORM).let { list ->
        return@let when (list.size) {
            2 -> list[0].isNotEmpty() && list[1].isEmpty()
            else -> false
        }
    }

    companion object {
        private const val AJOU_UNIV_DEFAULT_EMAIL_FORM = "@ajou.ac.kr"
    }
}