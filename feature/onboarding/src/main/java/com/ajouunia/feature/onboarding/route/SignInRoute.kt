package com.ajouunia.feature.onboarding.route

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
import com.ajouunia.core.designsystem.component.UniASingleButtonDialog
import com.ajouunia.core.designsystem.component.UniATwoButtonDialog
import com.ajouunia.feature.onboarding.ui.SignInScreen
import com.ajouunia.feature.onboarding.vm.SignInViewModel
import com.ajouunia.feature.onboarding.navigation.SIGN_IN_NAVIGATION_ROUTE
import com.ajouunia.feature.onboarding.state.SignInUIState

@Composable
internal fun SignInRoute(
    navigateToAgreementService: (NavOptions) -> Unit,
    navigateToForgotPassword: (NavOptions) -> Unit,
    navigateToMain: (NavOptions) -> Unit,
    viewModel: SignInViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.observeAsState()
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }

    when (val state = uiState) {
        is SignInUIState.FailSignIn -> {
            when (state.error) {
                else -> UniATwoButtonDialog(
                    title = "Login failed",
                    message = "Sorry, incorrect email or password.",
                    onClickConfirm = {
                        viewModel.clearState()
                    }
                )
            }
        }
        is SignInUIState.Loading -> {

        }
        is SignInUIState.MoveMain -> {
            val options = NavOptions.Builder()
                .setPopUpTo(SIGN_IN_NAVIGATION_ROUTE, inclusive = true)
                .build()
            navigateToMain(options)
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
            changeInputEmail = viewModel::changeInputId,
            changeInputPassword = viewModel::changeInputPassword,
            changeInputRemember = viewModel::changeInputRemember,
            validInfo = viewModel.isAvailableSignIn(),
            onClickSignIn = viewModel::signIn,
            navigateToAgreementService = navigateToAgreementService,
            navigateToForgotPassword = navigateToForgotPassword,
        )
    }

}