package com.ajouunia.feature.onboarding.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajouunia.core.domain.usecase.FindIdTokenByEmailUseCase
import com.ajouunia.core.domain.usecase.SignInUseCase
import com.ajouunia.feature.onboarding.state.SignInUIState
import com.ajouunia.feature.onboarding.vm.ConfirmEmailViewModel.Companion.AJOU_UNIV_DEFAULT_EMAIL_FORM
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel
@Inject
constructor(
    private val signInUseCase: SignInUseCase,
    private val findIdTokenByEmailUseCase: FindIdTokenByEmailUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<SignInUIState>(SignInUIState.Init)
    val uiState: LiveData<SignInUIState>
        get() = _uiState

    fun changeInputId(id: String) {
        _uiState.value = SignInUIState.UpdateInfo(
            id = id.replace(" ", ""),
            password = _uiState.value?.password ?: "",
            rememberSign = _uiState.value?.rememberSign ?: false
        )
    }

    fun changeInputPassword(password: String) {
        _uiState.value = SignInUIState.UpdateInfo(
            id = _uiState.value?.id ?: "",
            password = password.replace(" ", ""),
            rememberSign = _uiState.value?.rememberSign ?: false
        )
    }

    fun changeInputRemember(remember: Boolean) {
        _uiState.value = SignInUIState.UpdateInfo(
            id = _uiState.value?.id ?: "",
            password = _uiState.value?.password ?: "",
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
        val state = _uiState.value ?: return

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
            _uiState.postValue(
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
            _uiState.postValue(
                SignInUIState.FailSignIn(
                    id = state.id,
                    password = state.password,
                    rememberSign = state.rememberSign,
                    error = it
                )
            )
        }
    }

    private fun isValidId(): Boolean = _uiState.value?.id?.isNotEmpty() ?: false

    private fun isValidPassword(): Boolean = _uiState.value?.password?.let { password ->
        password.length in 4..12
    } ?: false

}