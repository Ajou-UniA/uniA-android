package com.ajouunia.feature.onboarding.route

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavOptions
import com.ajouunia.core.designsystem.UniAIconPack
import com.ajouunia.core.designsystem.component.UniATwoButtonDialog
import com.ajouunia.core.designsystem.uniaiconpack.IconBackArrow
import com.ajouunia.feature.onboarding.ui.ConfirmEmailScreen
import com.ajouunia.feature.onboarding.vm.ConfirmEmailViewModel
import com.ajouunia.feature.onboarding.navigation.CONFIRM_EMAIL_FORGOT_PASSWORD_NAVIGATION_ROUTE
import com.ajouunia.feature.onboarding.navigation.CONFIRM_EMAIL_SIGN_UP_NAVIGATION_ROUTE
import com.ajouunia.feature.onboarding.state.ConfirmEmailUIState

@Composable
internal fun ConfirmEmailRoute(
    isSignUp: Boolean,
    navigateToBack: () -> Unit,
    navigateToConfirmCodeSignUp: (NavOptions, String) -> Unit,
    navigateToConfirmCodeForgotPassword: (NavOptions, String) -> Unit,
    viewModel: ConfirmEmailViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.observeAsState()
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }

    when (val state = uiState) {
        is ConfirmEmailUIState.Success -> when (isSignUp) {
            true -> {
                val options = NavOptions.Builder()
                    .setPopUpTo(CONFIRM_EMAIL_SIGN_UP_NAVIGATION_ROUTE, inclusive = true)
                    .build()
                navigateToConfirmCodeSignUp(options, state.id)
            }
            false -> {
                val options = NavOptions.Builder()
                    .setPopUpTo(CONFIRM_EMAIL_FORGOT_PASSWORD_NAVIGATION_ROUTE, inclusive = true)
                    .build()
                navigateToConfirmCodeForgotPassword(options, state.id)
            }
        }
        is ConfirmEmailUIState.Loading -> {

        }
        is ConfirmEmailUIState.Error -> {
//            when (state.error) {
//                is InValidEmailException -> {
//
//                }
//                else -> viewModel.changeInputEmail("")
//            }
            UniATwoButtonDialog(
                title = "Invalid email address",
                message = "Please use a valid email domain in\nthe format of @ajou.ac.kr.",
                onClickConfirm = {
                    viewModel.changeInputEmail("")
                }
            )
        }
        else -> Unit
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
            ) {
                focusManager.clearFocus()
            },
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .background(Color.White),
                contentAlignment = Alignment.CenterStart
            ) {
                Icon(
                    UniAIconPack.IconBackArrow,
                    contentDescription = "back",
                    modifier = Modifier
                        .padding(start = 24.dp, top = 60.dp)
                        .clickable { navigateToBack() },
                )
            }
        }
    ) { padding ->
        uiState?.let { state ->
            ConfirmEmailScreen(
                modifier = Modifier.padding(padding),
                uiState = state,
                changeInputEmail = viewModel::changeInputEmail,
                enableButton = viewModel.isValidEmail(),
                onClickSubmit = viewModel::submitEmail,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConfirmEmailRoutePreview() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .background(Color.White),
                contentAlignment = Alignment.CenterStart
            ) {
                Icon(
                    UniAIconPack.IconBackArrow,
                    contentDescription = "back",
                    modifier = Modifier
                        .padding(start = 24.dp, top = 60.dp)
                        .clickable { },
                )
            }
        }
    ) { padding ->
        ConfirmEmailScreen(
            modifier = Modifier.padding(padding),
            uiState = ConfirmEmailUIState.Init,
            changeInputEmail = {},
            enableButton = true,
            onClickSubmit = {},
        )
    }
}