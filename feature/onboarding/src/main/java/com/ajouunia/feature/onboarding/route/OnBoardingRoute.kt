package com.ajouunia.feature.onboarding.route

import androidx.compose.runtime.Composable
import com.ajouunia.feature.onboarding.OnBoardingScreen

@Composable
internal fun OnBoardingRoute(navigateToBack: () -> Unit) {
    OnBoardingScreen(navigateToBack = navigateToBack)
}