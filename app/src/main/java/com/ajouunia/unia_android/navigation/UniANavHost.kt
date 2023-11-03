package com.ajouunia.unia_android.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.ajouunia.feature.mainroot.navigation.mainRoot
import com.ajouunia.feature.mainroot.navigation.navigateToMainRoot
import com.ajouunia.feature.onboarding.navigation.navigateToAgreementService
import com.ajouunia.feature.onboarding.navigation.navigateToConfirmEmailForgotPassword
import com.ajouunia.feature.onboarding.navigation.navigateToConfirmEmailSignUp
import com.ajouunia.feature.onboarding.navigation.navigateToForgotPassword
import com.ajouunia.feature.onboarding.navigation.navigateToOnBoarding
import com.ajouunia.feature.onboarding.navigation.navigateToSignIn
import com.ajouunia.feature.onboarding.navigation.navigateToSignUp
import com.ajouunia.feature.onboarding.navigation.navigateToVerificationCodeForgotPassword
import com.ajouunia.feature.onboarding.navigation.navigateToVerificationCodeSignUp
import com.ajouunia.feature.onboarding.navigation.onBoarding
import com.ajouunia.unia_android.ui.UniAAppState
import com.ajouunia.feature.splash.navigation.SPLASH_NAVIGATION_ROUTE
import com.ajouunia.feature.splash.navigation.splashScreen

@Composable
internal fun UniANavHost(
    modifier: Modifier = Modifier,
    appState: UniAAppState,
    onShowSnackBar: suspend (String) -> Boolean,
) {
    val navController = appState.navController

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = SPLASH_NAVIGATION_ROUTE,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
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
            navigateToConfirmEmailSignUp = navController::navigateToConfirmEmailSignUp,
            navigateToConfirmEmailForgotPassword = navController::navigateToConfirmEmailForgotPassword,
            navigateToVerificationCodeSignUp = navController::navigateToVerificationCodeSignUp,
            navigateToVerificationCodeForgotPassword = navController::navigateToVerificationCodeForgotPassword,
            navigateToSignUp = navController::navigateToSignUp,
            navigateToOnBoarding = navController::navigateToOnBoarding,
            navigateToMain = navController::navigateToMainRoot
        )
        mainRoot(
            navigateToBack = navController::popBackStack,
        )
    }

}