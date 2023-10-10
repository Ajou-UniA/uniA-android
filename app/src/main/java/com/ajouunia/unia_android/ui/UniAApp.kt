package com.ajouunia.unia_android.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import com.ajouunia.unia_android.navigation.UniANavHost

@Composable
fun UniAApp(appState: UniAAppState = rememberUniAAppState()) {
    val snackBarHostState = remember { SnackbarHostState() }
    val height = LocalConfiguration.current.screenHeightDp

    UniAAppBody(
        appState = appState,
        hostState = snackBarHostState,
        height = height
    )
}

@Composable
fun UniAAppBody(
    appState: UniAAppState,
    hostState: SnackbarHostState,
    height: Int
) = Scaffold(
    snackbarHost = {
//        SnackbarHost(
//            modifier = Modifier
//                .padding(bottom = (height - 96).dp)
//                .height(36.dp),
//            hostState = hostState,
//            snackbar = {
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 40.dp),
//                    shape = RoundedCornerShape(50.dp),
//                    colors = CardDefaults.cardColors(containerColor = Purple1),
//                    elevation = CardDefaults.cardElevation(8.dp),
//                ) {
//                    Box(Modifier.fillMaxSize()) {
//                }
//            },
//        )
    }
) { padding ->
    UniANavHost(
        modifier = Modifier.padding(padding),
        appState = appState
    ) { message ->
        hostState.showSnackbar(
            message = message,
            duration = SnackbarDuration.Short,
        ) == SnackbarResult.ActionPerformed
    }
}