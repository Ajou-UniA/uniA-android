package com.ajouunia.feature.home.route

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ajouunia.core.designsystem.R
import com.ajouunia.core.designsystem.component.NonScaleText
import com.ajouunia.feature.home.state.HomeUIState
import com.ajouunia.feature.home.ui.AjouUnivMapScreen
import com.ajouunia.feature.home.ui.HomeScreen
import com.ajouunia.feature.home.vm.HomeViewModel

@Composable
internal fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.fetchMapGuide(context.resources.assets)
    }

    Log.d("uiState", "uiState = ${uiState ?: "null"}")
    when (val state = uiState) {
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
        uiState?.let { state ->
            HomeScreen(
                modifier = Modifier.padding(paddingValues),
                uiState = state,
                onClickMap = viewModel::changeMapState
            )
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun HomeRoutePreview() {
    HomeRoute()
}