package com.ajouunia.feature.splash.state

sealed interface SplashUIState {
    object Init : SplashUIState
    object OnBoarding : SplashUIState
    object Home : SplashUIState
}