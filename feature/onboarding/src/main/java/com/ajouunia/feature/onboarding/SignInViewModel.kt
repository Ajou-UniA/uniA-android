package com.ajouunia.feature.onboarding

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajouunia.core.domain.usecase.FindIdTokenByEmailUseCase
import com.ajouunia.core.domain.usecase.SignInUseCase
import com.ajouunia.feature.onboarding.state.SignInUIState
import com.ajouunia.feature.onboarding.utils.isAjouUnivEmail
import com.ajouunia.feature.onboarding.utils.isEmptyId
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

    fun changeInputEmail(email: String) {
        _uiState.value = SignInUIState.UpdateInfo(
            email = email.replace(" ", ""),
            password = _uiState.value?.password ?: "",
            rememberSign = _uiState.value?.rememberSign ?: false
        )
    }

    fun changeInputPassword(password: String) {
        _uiState.value = SignInUIState.UpdateInfo(
            email = _uiState.value?.email ?: "",
            password = password.replace(" ", ""),
            rememberSign = _uiState.value?.rememberSign ?: false
        )
    }

    fun isAvailableSignIn() = isValidEmail() and isValidPassword()

    fun signIn() {
        val state = _uiState.value ?: return

        if (!isAvailableSignIn()) {
            return
        }

        _uiState.value = SignInUIState.Loading(
            email = state.email,
            password = state.password,
            rememberSign = state.rememberSign
        )

        remoteSignIn(state)
    }

    private fun remoteSignIn(state: SignInUIState) = viewModelScope.launch {
        signInUseCase(
            params = SignInUseCase.Params(
                userEmail = state.email,
                password = state.password
            )
        ).onSuccess {
            Log.d("signInUseCase", it.toString())
            remoteFetchIdToken(state)
        }.onFailure {
            Log.d("signInUseCase", it.toString())
            remoteFetchIdToken(state)
        }
    }

    private fun remoteFetchIdToken(state: SignInUIState) = viewModelScope.launch {
        findIdTokenByEmailUseCase(state.email).onSuccess {
            Log.d("findIdTokenByEmailUseCase", it.toString())
            _uiState.value = SignInUIState.MoveHome(
                email = state.email,
                password = state.password,
                rememberSign = state.rememberSign
            )
        }.onFailure {
            Log.d("findIdTokenByEmailUseCase", it.toString())
            _uiState.value = SignInUIState.FailSignIn(
                email = state.email,
                password = state.password,
                rememberSign = state.rememberSign
            )
        }
    }

    private fun isValidEmail(): Boolean = _uiState.value?.email?.let { email ->
        email.isAjouUnivEmail() && email.isEmptyId()
    } ?: false

    private fun isValidPassword(): Boolean = _uiState.value?.password?.let { password ->
        password.length in 4..12
    } ?: false

}