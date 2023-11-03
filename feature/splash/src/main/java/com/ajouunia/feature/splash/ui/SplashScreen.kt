package com.ajouunia.feature.splash.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavOptions
import com.ajouunia.core.designsystem.UniAIconPack
import com.ajouunia.core.designsystem.uniaiconpack.IconLogoName
import com.ajouunia.feature.splash.model.SplashUIState

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    uiState: SplashUIState,
    navigateToOnBoarding: (NavOptions) -> Unit,
    navigateToHome: (NavOptions) -> Unit,
) {
    val context = LocalContext.current

    Surface(
        modifier = modifier
            .fillMaxSize()
    ) {
        val logo = painterResource(com.ajouunia.core.designsystem.R.drawable.icon_logo_1x)
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = logo,
                contentDescription = null,
                modifier = Modifier.scale(2.0f)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Image(
                imageVector = UniAIconPack.IconLogoName,
                contentDescription = null,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(
        modifier = Modifier,
        uiState = SplashUIState.Init,
        navigateToOnBoarding = {
        },
        navigateToHome = {

        }
    )
}