package com.ajouunia.feature.onboarding

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajouunia.core.domain.usecase.IsVerifyCodeUseCase
import com.ajouunia.core.domain.usecase.SendVerificationCodeUseCase
import com.ajouunia.feature.onboarding.state.VerificationCodeUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerificationCodeViewModel
@Inject
constructor(
    private val isVerifyCodeUseCase: IsVerifyCodeUseCase,
    private val sendVerificationCodeUseCase: SendVerificationCodeUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<VerificationCodeUIState>(VerificationCodeUIState.Init)
    val uiState: LiveData<VerificationCodeUIState>
        get() = _uiState

    fun changeInputCode(code: String) {
        if (_uiState.value is VerificationCodeUIState.Loading) {
            return
        }

        if (code.isDigitsOnly()) {
            _uiState.value = VerificationCodeUIState.UpdateInfo(code)
        }
    }

    fun submitCode(userEmail: String) {
        if (_uiState.value is VerificationCodeUIState.Loading) {
            return
        }

        val code = _uiState.value?.code ?: ""

        if (!code.isDigitsOnly() || code.length != 4 || userEmail.isEmpty()) {
            return
        }

        _uiState.value = VerificationCodeUIState.Loading(code)

        remoteSubmitCode(
            userEmail = userEmail,
            code = code
        )
    }

    private fun remoteSubmitCode(
        userEmail: String,
        code: String
    ) = viewModelScope.launch {
        _uiState.postValue(VerificationCodeUIState.Success(code))
//        isVerifyCodeUseCase(
//            params = IsVerifyCodeUseCase.Params(
//                userEmail = userEmail,
//                code = code
//            )
//        ).onSuccess {
//            _uiState.postValue(VerificationCodeUIState.Success(code))
//        }.onFailure {
//            _uiState.postValue(
//                VerificationCodeUIState.Error(
//                    code = code,
//                    exception = it
//                )
//            )
//        }
    }

    fun resendCode(userEmail: String) {
        if (_uiState.value is VerificationCodeUIState.Loading) {
            return
        }

        _uiState.value = VerificationCodeUIState.Loading(code = "")

        remoteResendCode(userEmail)
    }

    private fun remoteResendCode(userEmail: String) = viewModelScope.launch {
        sendVerificationCodeUseCase(userEmail).onSuccess {
            _uiState.postValue(VerificationCodeUIState.Resend(code = ""))
        }.onFailure {
            _uiState.postValue(
                VerificationCodeUIState.Error(
                    code = "",
                    exception = it
                )
            )
        }
    }

}