package com.ajouunia.feature.onboarding.route

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavOptions
import com.ajouunia.feature.onboarding.AgreementServiceScreen
import com.ajouunia.feature.onboarding.AgreementServiceViewModel

@Composable
internal fun AgreementServiceRoute(
    navigateToTerms: (NavOptions) -> Unit,
    navigateToPrivacy: (NavOptions) -> Unit,
    navigateToConfirmEmail: (NavOptions) -> Unit,
    viewModel: AgreementServiceViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.observeAsState()

    uiState?.let { state ->
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),
            topBar = {

            }
        ) { padding ->
            AgreementServiceScreen(
                modifier = Modifier.padding(padding),
                navigateToConfirmEmail = navigateToConfirmEmail
            )
        }
    }
}