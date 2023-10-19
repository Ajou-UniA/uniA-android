package com.ajouunia.feature.guide.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.ajouunia.feature.guide.GuideScreen
import com.ajouunia.feature.guide.GuideViewModel

@Composable
internal fun GuideRoute(
    viewModel: GuideViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.observeAsState()

    uiState?.let { state ->
        GuideScreen(uiState = state)
    }
}