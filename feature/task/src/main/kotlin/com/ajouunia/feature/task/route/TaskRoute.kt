package com.ajouunia.feature.task.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.ajouunia.feature.task.TaskScreen
import com.ajouunia.feature.task.TaskViewModel

@Composable
internal fun TaskRoute(
    viewModel: TaskViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.observeAsState()

    uiState?.let { state ->
        TaskScreen(uiState = state)
    }
}