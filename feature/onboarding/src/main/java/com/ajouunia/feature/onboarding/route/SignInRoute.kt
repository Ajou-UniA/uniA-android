package com.ajouunia.feature.onboarding.route

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavOptions
import com.ajouunia.feature.onboarding.SignInScreen
import com.ajouunia.feature.onboarding.SignInViewModel
import com.ajouunia.feature.onboarding.state.SignInUIState

@Composable
internal fun SignInRoute(
    navigateToAgreementService: (NavOptions) -> Unit,
    navigateToForgotPassword: (NavOptions) -> Unit,
    navigateToHome: (NavOptions) -> Unit,
    viewModel: SignInViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.observeAsState()
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }

    Log.d("SignInState", uiState?.toString() ?: "")

    when (uiState) {
        is SignInUIState.SuccessSignIn -> {

        }
        is SignInUIState.FailSignIn -> {

        }
        is SignInUIState.Loading -> {

        }
        else -> Unit
    }

    uiState?.let { state ->
        SignInScreen(
            modifier = Modifier
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                ) {
                    focusManager.clearFocus()
                },
            uiState = state,
            changeInputEmail = viewModel::changeInputEmail,
            changeInputPassword = viewModel::changeInputPassword,
            changeInputRemember = viewModel::changeInputRemember,
            validInfo = viewModel.isAvailableSignIn(),
            onClickSignIn = viewModel::signIn,
            navigateToAgreementService = navigateToAgreementService,
            navigateToForgotPassword = navigateToForgotPassword,
        )
    }

}