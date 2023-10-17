package com.ajouunia.core.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ajouunia.core.designsystem.Purple2
import com.ajouunia.core.designsystem.urbanistFamily

@Composable
fun UniASingleButtonDialog(
    modifier: Modifier = Modifier,
    title: String,
    message: String,
    onClickConfirm: () -> Unit
) {
    val context = LocalContext.current
    Dialog(onDismissRequest = {}) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = White,
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        top = 25.dp,
                        bottom = 15.dp,
                        start = 15.dp,
                        end = 15.dp
                    ),
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 13.sp,
                        fontFamily = urbanistFamily,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(height = 26.dp))
                Text(
                    text = message,
                    style = TextStyle(
                        fontSize = 15.sp,
                        lineHeight = 11.sp,
                        fontFamily = urbanistFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(height = 26.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Purple2),
                    onClick = {
                        onClickConfirm()
                    },
                ) {
                    Text(
                        text = "OK",
                        style = TextStyle(
                            fontSize = 15.sp,
                            lineHeight = 10.sp,
                            fontFamily = urbanistFamily,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF8354FF),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UniASingleButtonDialogPreview() {
    UniASingleButtonDialog(
        title = "Login failed",
        message = "Sorry, incorrect email or password."
    ) {

    }
}