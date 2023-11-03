package com.ajouunia.feature.onboarding.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajouunia.core.domain.usecase.IsDuplicateEmailUseCase
import com.ajouunia.core.domain.usecase.SendVerificationCodeUseCase
import com.ajouunia.feature.onboarding.model.ConfirmEmailUIState
import com.ajouunia.feature.onboarding.utils.exceptions.InValidEmailException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfirmEmailViewModel
@Inject
constructor(
    private val isDuplicateEmailUseCase: IsDuplicateEmailUseCase,
    private val sendVerificationCodeUseCase: SendVerificationCodeUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<ConfirmEmailUIState>(ConfirmEmailUIState.Init)
    val uiState: StateFlow<ConfirmEmailUIState>
        get() = _uiState

    fun changeInputEmail(email: String) {
        if (_uiState.value is ConfirmEmailUIState.Loading) {
            return
        }

        _uiState.value = ConfirmEmailUIState.UpdateInfo(id = email.replace(" ", ""))
    }

    fun submitEmail() {
        val id = _uiState.value.id

        if (id.isEmpty()) {
            return
        }

        _uiState.value = ConfirmEmailUIState.Loading(id = id)

        remoteSubmitEmail(id)
    }

    private fun remoteSubmitEmail(id: String) = viewModelScope.launch {
        isDuplicateEmailUseCase(
            userEmail = id + AJOU_UNIV_DEFAULT_EMAIL_FORM
        ).onSuccess {
            when (it.result) {
                true -> remoteSendCode(id = id)
                false -> _uiState.emit(
                    ConfirmEmailUIState.Error(
                        id = id,
                        error = InValidEmailException()
                    )
                )
            }
        }.onFailure {
            _uiState.emit(ConfirmEmailUIState.Error(id, it))
        }
    }

    private fun remoteSendCode(id: String) = viewModelScope.launch {
        // TODO
//        _uiState.postValue(
//            ConfirmEmailUIState.Success(
//                id = id + AJOU_UNIV_DEFAULT_EMAIL_FORM
//            )
//        )
        sendVerificationCodeUseCase(userEmail = id + AJOU_UNIV_DEFAULT_EMAIL_FORM).onSuccess {
            _uiState.emit(
                ConfirmEmailUIState.Success(
                    id = id + AJOU_UNIV_DEFAULT_EMAIL_FORM
                )
            )
        }.onFailure {
            _uiState.emit(
                ConfirmEmailUIState.Error(
                    id = id,
                    error = it
                )
            )
        }
    }

    fun isValidEmail(): Boolean = _uiState.value.id.isNotEmpty()

    companion object {
        const val AJOU_UNIV_DEFAULT_EMAIL_FORM = "@ajou.ac.kr"
    }
}