package com.ajouunia.feature.community.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.ajouunia.feature.community.route.CommunityRoute

const val COMMUNITY_NAVIGATION_ROUTE = "community_route"

fun NavController.navigateToCommunity(navOptions: NavOptions? = null) {
    this.navigate(COMMUNITY_NAVIGATION_ROUTE, navOptions)
}

fun NavGraphBuilder.community() {
    composable(route = COMMUNITY_NAVIGATION_ROUTE) {
        CommunityRoute()
    }
}