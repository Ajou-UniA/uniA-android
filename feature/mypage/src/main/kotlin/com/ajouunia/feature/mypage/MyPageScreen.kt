package com.ajouunia.feature.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ajouunia.feature.mypage.state.MyPageUIState

@Composable
fun MyPageScreen(
    modifier: Modifier = Modifier,
    uiState: MyPageUIState
) {

    Box(modifier = modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "MyPage")
    }

}

@Preview(showBackground = true)
@Composable
fun MyPageScreenPreview() {
    MyPageScreen(uiState = MyPageUIState.Init)
}