package com.ajouunia.feature.guide

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ajouunia.feature.guide.state.GuideUIState

@Composable
fun GuideScreen(
    modifier: Modifier = Modifier,
    uiState: GuideUIState
) {

    Box(modifier = modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Guide")
    }

}

@Preview(showBackground = true)
@Composable
fun GuideScreenPreview() {
    GuideScreen(uiState = GuideUIState.Init)
}