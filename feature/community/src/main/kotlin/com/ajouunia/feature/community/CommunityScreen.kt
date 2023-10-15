package com.ajouunia.feature.community

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ajouunia.feature.community.state.CommunityUIState

@Composable
fun CommunityScreen(
    modifier: Modifier = Modifier,
    uiState: CommunityUIState
) {

    Box(modifier = modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Community")
    }

}

@Preview(showBackground = true)
@Composable
fun CommunityScreenPreview() {
    CommunityScreen(uiState = CommunityUIState.Init)
}