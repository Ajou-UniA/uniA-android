package com.ajouunia.feature.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.ajouunia.core.designsystem.Purple4
import com.ajouunia.core.designsystem.R
import com.ajouunia.core.designsystem.component.ZoomableBox


@Composable
fun AjouUnivMapScreen(
    modifier: Modifier = Modifier,
    onClickClose: () -> Unit = {}
) {
    Dialog(onDismissRequest = {}) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            ZoomableBox(
                modifier = modifier.fillMaxSize(),
                minScale = 1.0f
            ) {
                Image(
                    modifier = Modifier
                        .graphicsLayer(
                            scaleX = scale,
                            scaleY = scale,
                            translationX = offsetX,
                            translationY = offsetY
                        ),
                    painter = painterResource(id = R.drawable.ic_ajou_univ_map),
                    contentDescription = null
                )
            }
            IconButton(
                modifier = Modifier
                    .background(
                        color = Color(0xFFDABEFF),
                        shape = CircleShape
                    ),
                onClick = onClickClose
            ) {
                Icon(
                    Icons.Default.Close,
                    contentDescription = null,
                    tint = Purple4
                )
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun AjouUniVMapScreenPreview() {
    AjouUnivMapScreen()
}