package com.ajouunia.unia_android.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberUniAAppState(
    navController: NavHostController = rememberNavController()
): UniAAppState = remember(key1 = navController) {
    UniAAppState(navController = navController)
}


@Stable
class UniAAppState(val navController: NavHostController)