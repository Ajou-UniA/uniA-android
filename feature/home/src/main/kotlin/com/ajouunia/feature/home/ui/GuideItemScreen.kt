package com.ajouunia.feature.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajouunia.core.designsystem.component.NonScaleText
import com.ajouunia.core.domain.entity.AjouMapGuideEntity

@Composable
internal fun GuideItemScreen(
    modifier: Modifier = Modifier,
    item: AjouMapGuideEntity
) = Row(
    modifier = modifier
        .fillMaxWidth()
        .background(Color.White),
    verticalAlignment = Alignment.CenterVertically
) {
    NonScaleText(
        text = item.index.toString(),
        color = Color.Black,
        fontSize = 14.sp,
        fontWeight = FontWeight(600)
    )
    Spacer(modifier = Modifier.width(4.dp))
    NonScaleText(
        text = item.title,
        color = Color.Black,
        fontSize = 14.sp,
        fontWeight = FontWeight(600)
    )
}


@Preview(showBackground = true)
@Composable
private fun GuideItemScreenPreview() {
    GuideItemScreen(
        item = AjouMapGuideEntity(
            index = 1,
            title = "testGuide"
        )
    )
}