package com.ajouunia.feature.mypage.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ajouunia.feature.mypage.ui.MyPageScreen
import com.ajouunia.feature.mypage.vm.MyPageViewModel

@Composable
internal fun MyPageRoute(
    viewModel: MyPageViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    MyPageScreen(uiState = uiState)
}

@Preview(showBackground = true)
@Composable
private fun MyPageRoutePreview() {
    MyPageRoute()
}