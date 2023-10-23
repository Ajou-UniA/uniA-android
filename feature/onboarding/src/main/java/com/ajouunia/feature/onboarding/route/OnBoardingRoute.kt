package com.ajouunia.feature.onboarding.route

import androidx.compose.runtime.Composable
import com.ajouunia.feature.onboarding.ui.OnBoardingScreen

@Composable
internal fun OnBoardingRoute(navigateToBack: () -> Unit) {
    OnBoardingScreen(navigateToBack = navigateToBack)
}