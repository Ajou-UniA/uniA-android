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
import com.ajouunia.core.designsystem.uniaiconpack.IconBackArrow
import com.ajouunia.feature.onboarding.VerificationCodeScreen
import com.ajouunia.feature.onboarding.VerificationCodeViewModel
import com.ajouunia.feature.onboarding.navigation.VERIFICATION_CODE_SIGN_UP_NAVIGATION_ROUTE
import com.ajouunia.feature.onboarding.state.VerificationCodeUIState

@Composable
internal fun VerificationCodeRoute(
    userEmail: String,
    navigateToBack: () -> Unit,
    navigateToSignUp: ((NavOptions, String) -> Unit)?,
    navigateToResetPassword: ((NavOptions, String) -> Unit)?,
    viewModel: VerificationCodeViewModel = hiltViewModel()
) {
    
    val uiState by viewModel.uiState.observeAsState()
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }

    when (uiState) {
        is VerificationCodeUIState.Success -> {
            val options = NavOptions.Builder()
                .setPopUpTo(VERIFICATION_CODE_SIGN_UP_NAVIGATION_ROUTE, inclusive = true)
                .build()
            navigateToSignUp?.invoke(options, userEmail)
            navigateToResetPassword?.invoke(options, userEmail)
        }
        else -> Unit
    }

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
                        .clickable {
                            navigateToBack()
                        },
                )
            }
        }
    ) { padding ->
        uiState?.let { state ->
            VerificationCodeScreen(
                modifier = Modifier.padding(padding),
                uiState = state,
                changeInputCode = viewModel::changeInputCode
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VerificationCodeRoutePreview() {
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
                        .clickable {},
                )
            }
        }
    ) { padding ->
        VerificationCodeScreen(
            modifier = Modifier.padding(padding),
            uiState = VerificationCodeUIState.Init,
            changeInputCode = {}
        )
    }
}