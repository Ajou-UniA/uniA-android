package com.ajouunia.feature.guide.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.ajouunia.core.domain.entity.GuideEntity
import com.ajouunia.feature.guide.route.GuideInfoRoute
import com.ajouunia.feature.guide.route.GuideRoute

const val GUIDE_NAVIGATION_ROUTE = "guide_route"
const val GUIDE_INFO_NAVIGATION_ROUTE = "guide_route/{topic_index}/{guide_index}"

private var guideEntity: GuideEntity? = null

fun NavController.navigateToGuide(navOptions: NavOptions? = null) {
    this.navigate(GUIDE_NAVIGATION_ROUTE, navOptions)
}

fun NavController.navigateToGuideInfo(
    navOptions: NavOptions? = null,
    topicIndex: Int,
    entity: GuideEntity
) {
    guideEntity = entity
    val route = GUIDE_INFO_NAVIGATION_ROUTE.replace("{topic_index}", topicIndex.toString())
        .replace("{index}", entity.index.toString())
    this.navigate(route, navOptions)
}

fun NavGraphBuilder.guide(
    navigateToBack: () -> Unit,
    navigateToGuideInfo: (NavOptions, Int, GuideEntity) -> Unit
) {
    composable(route = GUIDE_NAVIGATION_ROUTE) {
        GuideRoute(
            navigateToGuideInfo = navigateToGuideInfo
        )
    }
    composable(route = GUIDE_INFO_NAVIGATION_ROUTE) {
        val topicIndex = it.arguments?.getInt("topic_index") ?: 0
        guideEntity?.let { guide ->
            GuideInfoRoute(
                topicIndex = topicIndex,
                guideEntity = guide,
                navigateToBack = navigateToBack
            )
        } ?: navigateToBack()
    }
}