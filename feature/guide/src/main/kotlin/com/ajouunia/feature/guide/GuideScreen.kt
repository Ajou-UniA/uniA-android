package com.ajouunia.feature.guide

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavOptions
import com.ajouunia.core.designsystem.Purple4
import com.ajouunia.core.designsystem.component.NonScaleText
import com.ajouunia.core.domain.entity.GuideEntity
import com.ajouunia.feature.guide.state.GuideUIState

@Composable
fun GuideScreen(
    modifier: Modifier = Modifier,
    uiState: GuideUIState,
    navigateToGuideInfo: (NavOptions, Int, GuideEntity) -> Unit = { _, _, _ -> },
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        NonScaleText(
            text = menuList[uiState.topicIndex],
            fontSize = 18.sp,
            lineHeight = 13.sp,
            fontWeight = FontWeight(700),
            color = Purple4,
            modifier = Modifier.padding(start = 16.dp, top = 32.dp, bottom = 32.dp)
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(uiState.guideList.size) { index ->
                GuideItemScreen(
                    uiState = uiState,
                    guideEntity = uiState.guideList[index],
                    navigateToGuideInfo = navigateToGuideInfo
                )
            }
            item {
                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = Color(0xFFE3E3E3)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GuideScreenPreview() {
    GuideScreen(uiState = GuideUIState.Init)
}