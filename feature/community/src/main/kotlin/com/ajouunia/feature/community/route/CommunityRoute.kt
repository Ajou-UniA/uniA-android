package com.ajouunia.feature.community.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.ajouunia.feature.community.CommunityScreen
import com.ajouunia.feature.community.CommunityViewModel

@Composable
internal fun CommunityRoute(
    viewModel: CommunityViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.observeAsState()

    uiState?.let { state ->
        CommunityScreen(uiState = state)
    }
}