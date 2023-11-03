package com.ajouunia.feature.task.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ajouunia.feature.task.state.TaskUIState

@Composable
fun TaskScreen(
    modifier: Modifier = Modifier,
    uiState: TaskUIState
) {

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        items(uiState.taskList.size) { index ->
            TaskInfoScreen(entity = uiState.taskList[index])
        }

        item {
            Divider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color(0xFFE3E3E3)
            )
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun TaskScreenPreview() {
    TaskScreen(uiState = TaskUIState.Init)
}