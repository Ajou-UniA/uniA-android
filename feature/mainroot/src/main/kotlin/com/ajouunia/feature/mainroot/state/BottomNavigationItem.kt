package com.ajouunia.feature.mainroot.state

import androidx.compose.ui.graphics.vector.ImageVector
import com.ajouunia.core.designsystem.UniAIconPack
import com.ajouunia.core.designsystem.uniaiconpack.IcAjouGuide
import com.ajouunia.core.designsystem.uniaiconpack.IcCommunity
import com.ajouunia.core.designsystem.uniaiconpack.IcHome
import com.ajouunia.core.designsystem.uniaiconpack.IcMyPage
import com.ajouunia.core.designsystem.uniaiconpack.IcMyTasks
import com.ajouunia.core.designsystem.uniaiconpack.IcSelectedAjouGuide
import com.ajouunia.core.designsystem.uniaiconpack.IcSelectedCommunity
import com.ajouunia.core.designsystem.uniaiconpack.IcSelectedHome
import com.ajouunia.core.designsystem.uniaiconpack.IcSelectedMyPage
import com.ajouunia.core.designsystem.uniaiconpack.IcSelectedMyTaks
import com.ajouunia.feature.community.navigation.COMMUNITY_NAVIGATION_ROUTE
import com.ajouunia.feature.guide.navigation.GUIDE_NAVIGATION_ROUTE
import com.ajouunia.feature.home.navigation.HOME_NAVIGATION_ROUTE
import com.ajouunia.feature.mypage.navigation.MY_PAGE_NAVIGATION_ROUTE
import com.ajouunia.feature.task.navigation.TASK_NAVIGATION_ROUTE

data class BottomNavigationItem(
    val label: String = "",
    val defaultIcon: ImageVector = UniAIconPack.IcHome,
    val selectedIcon: ImageVector = UniAIconPack.IcSelectedHome,
    val route: String = ""
) {
    fun bottomNavigationItems() : List<BottomNavigationItem> = listOf(
        BottomNavigationItem(
            label = "My Tasks",
            defaultIcon = UniAIconPack.IcMyTasks,
            selectedIcon = UniAIconPack.IcSelectedMyTaks,
            route = TASK_NAVIGATION_ROUTE
        ),
        BottomNavigationItem(
            label = "Ajou Guide",
            defaultIcon = UniAIconPack.IcAjouGuide,
            selectedIcon = UniAIconPack.IcSelectedAjouGuide,
            route = GUIDE_NAVIGATION_ROUTE
        ),
        BottomNavigationItem(
            label = "Home",
            defaultIcon = UniAIconPack.IcHome,
            selectedIcon = UniAIconPack.IcSelectedHome,
            route = HOME_NAVIGATION_ROUTE
        ),
        BottomNavigationItem(
            label = "Community",
            defaultIcon = UniAIconPack.IcCommunity,
            selectedIcon = UniAIconPack.IcSelectedCommunity,
            route = COMMUNITY_NAVIGATION_ROUTE
        ),
        BottomNavigationItem(
            label = "My Page",
            defaultIcon = UniAIconPack.IcMyPage,
            selectedIcon = UniAIconPack.IcSelectedMyPage,
            route = MY_PAGE_NAVIGATION_ROUTE
        )
    )
}
