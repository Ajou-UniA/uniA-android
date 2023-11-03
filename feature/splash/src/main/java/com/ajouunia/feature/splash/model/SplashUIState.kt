package com.ajouunia.feature.splash.model

sealed interface SplashUIState {
    object Init : SplashUIState
    object OnBoarding : SplashUIState
    object Home : SplashUIState
}