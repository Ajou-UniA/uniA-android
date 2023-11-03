package com.ajouunia.feature.guide.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavOptions
import com.ajouunia.core.designsystem.component.NonScaleText
import com.ajouunia.core.domain.entity.GuideEntity
import com.ajouunia.feature.guide.model.GuideUIState

@Composable
internal fun GuideItemScreen(
    modifier: Modifier = Modifier,
    uiState: GuideUIState,
    guideEntity: GuideEntity,
    navigateToGuideInfo: (NavOptions, Int, GuideEntity) -> Unit = { _, _, _ -> },
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(Color.White)
            .clickable {
                val options = NavOptions.Builder().build()
                navigateToGuideInfo(options, uiState.topicIndex, guideEntity)
            }
    ) {
        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color(0xFFE3E3E3)
        )
        NonScaleText(
            text = guideEntity.title,
            fontSize = 15.sp,
            fontWeight = FontWeight(600),
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 25.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun GuideItemScreenPreview() {
    GuideItemScreen(
        uiState = GuideUIState.Init,
        guideEntity = GuideEntity(
            index = 1,
            title = "Counseling & Support Office for\nInternational Students",
            content = "test"
        )
    )
}