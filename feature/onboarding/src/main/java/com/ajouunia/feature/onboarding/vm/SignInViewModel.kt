package com.ajouunia.feature.onboarding.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajouunia.core.domain.usecase.FindIdTokenByEmailUseCase
import com.ajouunia.core.domain.usecase.SignInUseCase
import com.ajouunia.feature.onboarding.model.SignInUIState
import com.ajouunia.feature.onboarding.vm.ConfirmEmailViewModel.Companion.AJOU_UNIV_DEFAULT_EMAIL_FORM
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel
@Inject
constructor(
    private val signInUseCase: SignInUseCase,
    private val findIdTokenByEmailUseCase: FindIdTokenByEmailUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<SignInUIState>(SignInUIState.Init)
    val uiState: StateFlow<SignInUIState>
        get() = _uiState

    fun changeInputId(id: String) {
        _uiState.value = SignInUIState.UpdateInfo(
            id = id.replace(" ", ""),
            password = _uiState.value.password,
            rememberSign = _uiState.value.rememberSign
        )
    }

    fun changeInputPassword(password: String) {
        _uiState.value = SignInUIState.UpdateInfo(
            id = _uiState.value.id,
            password = password.replace(" ", ""),
            rememberSign = _uiState.value.rememberSign
        )
    }

    fun changeInputRemember(remember: Boolean) {
        _uiState.value = SignInUIState.UpdateInfo(
            id = _uiState.value.id,
            password = _uiState.value.password,
            rememberSign = remember
        )
    }

    fun clearState() {
        _uiState.value = SignInUIState.UpdateInfo(
            id = "",
            password = "",
            rememberSign = false
        )
    }

    fun isAvailableSignIn() = isValidId() and isValidPassword()

    fun signIn() {
        val state = _uiState.value

        if (!isAvailableSignIn()) {
            return
        }

        _uiState.value = SignInUIState.Loading(
            id = state.id,
            password = state.password,
            rememberSign = state.rememberSign
        )

        remoteSignIn(state)
    }

    private fun remoteSignIn(state: SignInUIState) = viewModelScope.launch {
        signInUseCase(
            params = SignInUseCase.Params(
                userEmail = state.id + AJOU_UNIV_DEFAULT_EMAIL_FORM,
                password = state.password
            )
        ).onSuccess {
            Log.d("signInUseCase", it.toString())
            when (it.result) {
                true -> remoteFetchIdToken(state)
                false ->
                    remoteFetchIdToken(state)
//                    _uiState.postValue(
//                    SignInUIState.FailSignIn(
//                        id = state.id,
//                        password = state.password,
//                        rememberSign = state.rememberSign,
//                    )
//                )
            }
        }.onFailure {
            Log.d("signInUseCase", it.toString())
            remoteFetchIdToken(state)
//            _uiState.postValue(
//                SignInUIState.FailSignIn(
//                    id = state.id,
//                    password = state.password,
//                    rememberSign = state.rememberSign,
//                    error = it
//                )
//            )
        }
    }

    private fun remoteFetchIdToken(state: SignInUIState) = viewModelScope.launch {
        findIdTokenByEmailUseCase(
            state.id + AJOU_UNIV_DEFAULT_EMAIL_FORM
        ).onSuccess {
            _uiState.emit(
                when (it.result) {
                    true -> SignInUIState.MoveMain(
                        id = state.id,
                        password = state.password,
                        rememberSign = state.rememberSign
                    )
                    false -> SignInUIState.FailSignIn(
                        id = state.id,
                        password = state.password,
                        rememberSign = state.rememberSign,
                        error = null
                    )
                }
            )
        }.onFailure {
            _uiState.emit(
                SignInUIState.FailSignIn(
                    id = state.id,
                    password = state.password,
                    rememberSign = state.rememberSign,
                    error = it
                )
            )
        }
    }

    private fun isValidId(): Boolean = _uiState.value.id.isNotEmpty()

    private fun isValidPassword(): Boolean = _uiState.value.password.length in 4..12

}