package com.ajouunia.feature.guide.route

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajouunia.core.designsystem.UniAIconPack
import com.ajouunia.core.designsystem.component.NonScaleText
import com.ajouunia.core.designsystem.uniaiconpack.IconBackArrow
import com.ajouunia.core.domain.entity.GuideEntity
import com.ajouunia.feature.guide.ui.GuideInfoScreen
import com.ajouunia.feature.guide.ui.menuList

@Composable
internal fun GuideInfoRoute(
    topicIndex: Int,
    guideEntity: GuideEntity,
    navigateToBack: () -> Unit = {}
) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .statusBarsPadding()
                    .padding(24.dp),
                contentAlignment = Alignment.CenterStart,
            ) {
                Icon(
                    UniAIconPack.IconBackArrow,
                    contentDescription = "back",
                    modifier = Modifier
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = navigateToBack,
                        )
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .statusBarsPadding()
                    .padding(24.dp),
                contentAlignment = Alignment.Center,
            ) {
                NonScaleText(
                    text = menuList[topicIndex],
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700)
                )
            }
        }
    ) { paddingValues ->
        GuideInfoScreen(
            modifier = Modifier.fillMaxSize()
                .background(Color.White)
                .padding(paddingValues),
            guideEntity = guideEntity
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun GuideInfoRoutePreview() {
    GuideInfoRoute(
        topicIndex = 1,
        guideEntity = GuideEntity(
            index = 1,
            title = "testTitletestTitletestTitletestTitle",
            content = "testContenttestContenttestContenttestContenttestContenttestContenttestContenttestContenttestContenttestContenttestContenttestContenttestContenttestContent"
        )
    )
}