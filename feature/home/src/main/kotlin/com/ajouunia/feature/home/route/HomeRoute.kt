package com.ajouunia.feature.home.route

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ajouunia.core.designsystem.R
import com.ajouunia.feature.home.model.HomeUIState
import com.ajouunia.feature.home.ui.AjouUnivMapScreen
import com.ajouunia.feature.home.ui.HomeScreen
import com.ajouunia.feature.home.vm.HomeViewModel

@Composable
internal fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.fetchMapGuide(context.resources.assets)
    }

    Log.d("uiState", "uiState = $uiState")
    when (uiState) {
        is HomeUIState.Map -> AjouUnivMapScreen(onClickClose = viewModel::closeMapState)
        else -> Unit
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .width(30.dp)
                        .height(34.dp),
                    painter = painterResource(id = R.drawable.icon_logo_1x),
                    contentDescription = null
                )
            }
        },
    ) { paddingValues ->
        HomeScreen(
            modifier = Modifier.padding(paddingValues),
            uiState = uiState,
            onClickMap = viewModel::changeMapState
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeRoutePreview() {
    HomeRoute()
}