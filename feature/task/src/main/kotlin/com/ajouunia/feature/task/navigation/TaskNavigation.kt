package com.ajouunia.feature.task.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.ajouunia.feature.task.route.TaskRoute

const val TASK_NAVIGATION_ROUTE = "task_route"

fun NavController.navigateToTask(navOptions: NavOptions? = null) {
    this.navigate(TASK_NAVIGATION_ROUTE, navOptions)
}

fun NavGraphBuilder.task() {
    composable(route = TASK_NAVIGATION_ROUTE) {
        TaskRoute()
    }
}