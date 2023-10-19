package com.ajouunia.feature.mypage.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.ajouunia.feature.mypage.MyPageScreen
import com.ajouunia.feature.mypage.MyPageViewModel

@Composable
internal fun MyPageRoute(
    viewModel: MyPageViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.observeAsState()

    uiState?.let { state ->
        MyPageScreen(uiState = state)
    }
}