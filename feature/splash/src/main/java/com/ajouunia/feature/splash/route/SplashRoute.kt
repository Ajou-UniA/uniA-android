package com.ajouunia.feature.splash.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavOptions
import com.ajouunia.feature.splash.model.SplashUIState
import com.ajouunia.feature.splash.navigation.SPLASH_NAVIGATION_ROUTE
import com.ajouunia.feature.splash.ui.SplashScreen
import com.ajouunia.feature.splash.vm.SplashViewModel

@Composable
internal fun SplashRoute(
    navigateToOnBoarding: (NavOptions) -> Unit,
    navigateToHome: (NavOptions) -> Unit,
    viewModel: SplashViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        is SplashUIState.OnBoarding -> {
            val options = NavOptions.Builder()
                .setPopUpTo(SPLASH_NAVIGATION_ROUTE, inclusive = true)
                .build()
            navigateToOnBoarding(options)
        }
        else -> Unit
    }

    SplashScreen(
        uiState = uiState,
        navigateToOnBoarding = navigateToOnBoarding,
        navigateToHome = navigateToHome
    )

}
