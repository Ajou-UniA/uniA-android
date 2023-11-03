package com.ajouunia.feature.community.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ajouunia.feature.community.ui.CommunityScreen
import com.ajouunia.feature.community.vm.CommunityViewModel

@Composable
internal fun CommunityRoute(
    viewModel: CommunityViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    CommunityScreen(uiState = uiState)
}