package com.ajouunia.feature.onboarding.vm

import androidx.lifecycle.ViewModel
import com.ajouunia.feature.onboarding.model.SignUpUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel
@Inject
constructor(

) : ViewModel() {
    private val _uiState = MutableStateFlow<SignUpUiState>(SignUpUiState.Init)
    val uiState: StateFlow<SignUpUiState>
        get() = _uiState

    private val specialCharacters by lazy{
        setOf(
            '!',
            '@',
            '#',
            '$',
            '%',
            '^',
            '&',
            '*',
            '(',
            ')',
            '-',
            '+',
            '=',
            ',',
            '.',
            '/',
            '?',
            '~'
        )
    }

    fun changeInfoFirstName(firstName: String) {
        val state = _uiState.value

        when (state) {
            is SignUpUiState.Loading -> return
            else -> Unit
        }

        _uiState.value = SignUpUiState.UpdateInfo(state.infoState.copy(firstName = firstName))
    }

    fun changeInfoLastName(lastName: String) {
        val state = _uiState.value

        when (state) {
            is SignUpUiState.Loading -> return
            else -> Unit
        }

        _uiState.value = SignUpUiState.UpdateInfo(state.infoState.copy(lastName = lastName))
    }

    fun changeInfoStudentId(studentId: String) {
        val state = _uiState.value

        when (studentId.isEmpty()) {
            true -> Unit
            false -> kotlin.runCatching { studentId.toLong() }.onFailure { return }
        }

        when (state) {
            is SignUpUiState.Loading -> return
            else -> Unit
        }

        _uiState.value = SignUpUiState.UpdateInfo(state.infoState.copy(studentId = studentId))
    }

    fun changeInfoDepartment(department: String) {
        val state = _uiState.value

        when (state) {
            is SignUpUiState.Loading -> return
            else -> Unit
        }

        _uiState.value = SignUpUiState.UpdateInfo(state.infoState.copy(department = department))
    }

    fun changeInfoPassword(password: String) {
        val state = _uiState.value

        when (state) {
            is SignUpUiState.Loading -> return
            else -> Unit
        }

        val value = password.replace(" ", "")

        _uiState.value = SignUpUiState.UpdateInfo(
            state.infoState.copy(
                password = value,
                isValidPassword = password.isValidPassword(),
                isValidConfirmPassword = passwordConfirmCheck(
                    password = value,
                    confirmPassword = state.infoState.confirmPassword
                )
            )
        )
    }

    fun changeInfoConfirmPassword(confirmPassword: String) {
        val state = _uiState.value

        when (state) {
            is SignUpUiState.Loading -> return
            else -> Unit
        }

        val value = confirmPassword.replace(" ", "")

        _uiState.value = SignUpUiState.UpdateInfo(
            state.infoState.copy(
                confirmPassword = value,
                isValidConfirmPassword = passwordConfirmCheck(
                    password = state.infoState.password,
                    confirmPassword = value
                )
            )
        )
    }

    fun onClickDepartment() {
        val state = _uiState.value

        when (state) {
            is SignUpUiState.Loading -> return
            else -> Unit
        }

        _uiState.value = SignUpUiState.DepartmentDialog(state.infoState.copy())
    }

    private fun passwordConfirmCheck(password: String, confirmPassword: String): Boolean {
        if (!password.isValidPassword() or password.isEmpty()) {
             return false
        }

        if (!confirmPassword.isValidPassword() or confirmPassword.isEmpty()) {
            return false
        }

        return when (password) {
            confirmPassword -> true
            else -> false
        }
    }

    private fun String.isValidPassword(): Boolean {
        if (this.length < 8) {
            return false
        }

        if (!this.any { it in specialCharacters }) {
            return false
        }

        return true
    }

}