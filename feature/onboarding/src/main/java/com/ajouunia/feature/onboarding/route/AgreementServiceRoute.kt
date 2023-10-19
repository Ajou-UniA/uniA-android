package com.ajouunia.feature.onboarding.route

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavOptions
import com.ajouunia.core.designsystem.UniAIconPack
import com.ajouunia.core.designsystem.uniaiconpack.IconBackArrow
import com.ajouunia.feature.onboarding.AgreementServiceScreen
import com.ajouunia.feature.onboarding.AgreementServiceViewModel

@Composable
internal fun AgreementServiceRoute(
    navigateToBack: () -> Unit,
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
                Box(
                    modifier = Modifier.fillMaxWidth()
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
            AgreementServiceScreen(
                modifier = Modifier.padding(padding),
                navigateToConfirmEmail = navigateToConfirmEmail
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AgreementServiceRoutePreview() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        topBar = {
            Box(
                modifier = Modifier.fillMaxWidth()
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
        AgreementServiceScreen(
            modifier = Modifier.padding(padding),
            navigateToConfirmEmail = {}
        )
    }
}