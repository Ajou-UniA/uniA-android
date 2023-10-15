package com.ajouunia.feature.guide.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.ajouunia.feature.guide.route.GuideRoute

const val GUIDE_NAVIGATION_ROUTE = "guide_route"

fun NavController.navigateToGuide(navOptions: NavOptions? = null) {
    this.navigate(GUIDE_NAVIGATION_ROUTE, navOptions)
}

fun NavGraphBuilder.guide() {
    composable(route = GUIDE_NAVIGATION_ROUTE) {
        GuideRoute()
    }
}