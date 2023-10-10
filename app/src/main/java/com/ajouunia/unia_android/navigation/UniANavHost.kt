package com.ajouunia.unia_android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.ajouunia.feature.onboarding.navigation.navigateToAgreementService
import com.ajouunia.feature.onboarding.navigation.navigateToForgotPassword
import com.ajouunia.feature.onboarding.navigation.navigateToSignIn
import com.ajouunia.feature.onboarding.navigation.onBoarding
import com.ajouunia.unia_android.ui.UniAAppState
import com.ajouunia.feature.splash.navigation.SPLASH_NAVIGATION_ROUTE
import com.ajouunia.feature.splash.navigation.splashScreen

@Composable
fun UniANavHost(
    modifier: Modifier = Modifier,
    appState: UniAAppState,
    onShowSnackBar: suspend (String) -> Boolean,
) {
    val navController = appState.navController

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = SPLASH_NAVIGATION_ROUTE,
    ) {
        splashScreen(
            navigateToOnBoarding = navController::navigateToSignIn,
            navigateToHome = {

            }
        )
        onBoarding(
            navigateToBack = navController::popBackStack,
            navigateToAgreementService = navController::navigateToAgreementService,
            navigateToForgotPassword = navController::navigateToForgotPassword,
            navigateToHome = {

            }
        )
    }

}