package com.ajouunia.feature.mainroot.route

import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.BackHandler
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ajouunia.core.designsystem.Purple4
import com.ajouunia.core.designsystem.UniAIconPack
import com.ajouunia.core.designsystem.uniaiconpack.IcHome
import com.ajouunia.core.designsystem.uniaiconpack.IcSelectedHome
import com.ajouunia.core.designsystem.urbanistFamily
import com.ajouunia.feature.community.navigation.COMMUNITY_NAVIGATION_ROUTE
import com.ajouunia.feature.community.navigation.community
import com.ajouunia.feature.guide.navigation.GUIDE_NAVIGATION_ROUTE
import com.ajouunia.feature.guide.navigation.guide
import com.ajouunia.feature.guide.navigation.navigateToGuide
import com.ajouunia.feature.guide.navigation.navigateToGuideInfo
import com.ajouunia.feature.home.navigation.HOME_NAVIGATION_ROUTE
import com.ajouunia.feature.home.navigation.home
import com.ajouunia.feature.mainroot.state.BottomNavigationItem
import com.ajouunia.feature.mypage.navigation.MY_PAGE_NAVIGATION_ROUTE
import com.ajouunia.feature.mypage.navigation.myPage
import com.ajouunia.feature.task.navigation.TASK_NAVIGATION_ROUTE
import com.ajouunia.feature.task.navigation.task

@Composable
internal fun MainRootRoute(
    modifier: Modifier = Modifier
) {
    var navigationSelectedItem by remember {
        mutableIntStateOf(2)
    }
    val navController = rememberNavController()

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {

        },
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE3E3E3),
                        shape = RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp
                        )
                    ),
                containerColor = Color.White,
                contentColor = Color.White,
                tonalElevation = 0.dp
            ) {
                BottomNavigationItem().bottomNavigationItems().forEachIndexed { index, navigationItem ->
                    NavigationBarItem(
                        selected = index == navigationSelectedItem,
                        label = {
                            Text(
                                text = navigationItem.label,
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    lineHeight = 8.sp,
                                    fontFamily = urbanistFamily,
                                    fontWeight = FontWeight(700),
                                    color = when (index) {
                                        navigationSelectedItem -> Purple4
                                        else -> Color(0xFF8A8A8A)
                                    },
                                    textAlign = TextAlign.Center,
                                )
                            )
                        },
                        icon = {
                            Image(
                                imageVector = when (index) {
                                    navigationSelectedItem -> navigationItem.selectedIcon
                                    else -> navigationItem.defaultIcon
                                },
                                contentDescription = navigationItem.label
                            )
                        },
                        colors =  NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            unselectedIconColor = Color.White,
                            selectedTextColor = Color.Transparent,
                            indicatorColor = Color.White
                        ),
                        onClick = {
                            navigationSelectedItem = index
                            navController.navigate(navigationItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = HOME_NAVIGATION_ROUTE,
            modifier = Modifier.padding(paddingValues = padding),
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }
        ) {
            task()
            guide(
                navigateToBack = navController::popBackStack,
                navigateToGuideInfo = navController::navigateToGuideInfo
            )
            home()
            community()
            myPage()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainRootRoutePreview() {
    var navigationSelectedItem by remember {
        mutableIntStateOf(2)
    }
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {

        },
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE3E3E3),
                        shape = RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp
                        )
                    ),
                containerColor = Color.White,
                contentColor = Color.White,
                tonalElevation = 0.dp
            ) {
                BottomNavigationItem().bottomNavigationItems().forEachIndexed { index, navigationItem ->
                    NavigationBarItem(
                        selected = index == navigationSelectedItem,
                        label = {
                            Text(
                                text = navigationItem.label,
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    lineHeight = 8.sp,
                                    fontFamily = urbanistFamily,
                                    fontWeight = FontWeight(700),
                                    color = when (index) {
                                        navigationSelectedItem -> Purple4
                                        else -> Color(0xFF8A8A8A)
                                    },
                                    textAlign = TextAlign.Center,
                                )
                            )
                        },
                        icon = {
                            Image(
                                imageVector = when (index) {
                                    navigationSelectedItem -> navigationItem.selectedIcon
                                    else -> navigationItem.defaultIcon
                                },
                                contentDescription = navigationItem.label
                            )
                        },
                        colors =  NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            unselectedIconColor = Color.White,
                            selectedTextColor = Color.Transparent,
                            indicatorColor = Color.White
                        ),
                        onClick = {
                            navigationSelectedItem = index
                            navController.navigate(navigationItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { padding ->
    }
}