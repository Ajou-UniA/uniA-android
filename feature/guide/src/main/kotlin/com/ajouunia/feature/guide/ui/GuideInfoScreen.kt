package com.ajouunia.feature.guide.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajouunia.core.designsystem.Purple4
import com.ajouunia.core.designsystem.component.NonScaleText
import com.ajouunia.core.domain.entity.GuideEntity

@Composable
internal fun GuideInfoScreen(
    modifier: Modifier = Modifier,
    guideEntity: GuideEntity
) = Column(
    modifier = modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(20.dp)
    ) {
        NonScaleText(
            text = guideEntity.title,
            fontSize = 18.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight(700),
            color = Purple4,
        )
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F5F5))
            .padding(20.dp)
    ) {
        item {
            NonScaleText(
                text = guideEntity.content,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight(500),
                lineHeight = 22.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GuideInfoScreenPreview() {
    GuideInfoScreen(
        modifier = Modifier.fillMaxSize()
            .background(Color.White),
        guideEntity = GuideEntity(
            index = 1,
            title = "testTitletestTitletestTitletestTitle",
            content = "testContenttestContenttestContenttestContenttestContenttestContenttestContenttestContenttestContenttestContenttestContenttestContenttestContenttestContent"
        )
    )
}