package com.ajouunia.feature.mainroot.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.ajouunia.feature.mainroot.route.MainRootRoute

const val MAIN_ROOT_NAVIGATION_ROUTE = "main_root_route"

fun NavController.navigateToMainRoot(navOptions: NavOptions? = null) {
    this.navigate(MAIN_ROOT_NAVIGATION_ROUTE, navOptions)
}

fun NavGraphBuilder.mainRoot(
    navigateToBack: () -> Unit,
) {
    composable(route = MAIN_ROOT_NAVIGATION_ROUTE) {
        MainRootRoute()
    }
}