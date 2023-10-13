package com.ajouunia.feature.onboarding.route

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
            uiState = state,
            changeInputEmail = viewModel::changeInputEmail,
            changeInputPassword = viewModel::changeInputPassword,
            validInfo = viewModel.isAvailableSignIn(),
            onClickSignIn = viewModel::signIn,
            navigateToAgreementService = navigateToAgreementService,
            navigateToForgotPassword = navigateToForgotPassword,
            navigateToHome = navigateToHome
        )
    }

}