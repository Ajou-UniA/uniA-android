package com.ajouunia.feature.home.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.ajouunia.feature.home.HomeScreen
import com.ajouunia.feature.home.HomeViewModel

@Composable
internal fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.observeAsState()

    uiState?.let { state ->
        HomeScreen(uiState = state)
    }
}