package com.ajouunia.feature.mypage.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.ajouunia.feature.mypage.route.MyPageRoute

const val MY_PAGE_NAVIGATION_ROUTE = "my_page_route"

fun NavController.navigateToMyPage(navOptions: NavOptions? = null) {
    this.navigate(MY_PAGE_NAVIGATION_ROUTE, navOptions)
}

fun NavGraphBuilder.myPage() {
    composable(route = MY_PAGE_NAVIGATION_ROUTE) {
        MyPageRoute()
    }
}