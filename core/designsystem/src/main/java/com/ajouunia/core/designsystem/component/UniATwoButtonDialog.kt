package com.ajouunia.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ajouunia.core.designsystem.Purple4

@Composable
fun UniATwoButtonDialog(
    modifier: Modifier = Modifier,
    title: String,
    message: String,
    onClickConfirm: () -> Unit = {},
    onClickCancel: (() -> Unit)? = null
) {
    Dialog(onDismissRequest = {}) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(color = Color.White, shape = RoundedCornerShape(16.dp))
                .padding(
                    top = 25.dp,
                    start = 25.dp,
                    end = 20.dp
                ),
        ) {
            NonScaleText(
                text = title,
                fontSize = 18.sp,
                lineHeight = 13.sp,
                fontWeight = FontWeight(700),
                color = Color.Black,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(height = 26.dp))
            NonScaleText(
                text = message,
                fontSize = 15.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF000000),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(height = 26.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                onClickCancel?.let {
                    Button(
                        colors = ButtonDefaults.buttonColors(Color.White),
                        onClick = {
                            it()
                        },
                    ) {
                        NonScaleText(
                            text = "Cancel",
                            fontSize = 15.sp,
                            lineHeight = 10.sp,
                            fontWeight = FontWeight(600),
                            color = Purple4,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
                Button(
                    colors = ButtonDefaults.buttonColors(Color.White),
                    onClick = {
                        onClickConfirm()
                    },
                ) {
                    NonScaleText(
                        text = "OK",
                        fontSize = 15.sp,
                        lineHeight = 10.sp,
                        fontWeight = FontWeight(600),
                        color = Purple4,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UniADialogPreview() {
    UniATwoButtonDialog(
        title = "Dialog message",
        message = "Dialog message with just OK button.",
        onClickConfirm = {

        }
    )
}

@Preview(showBackground = true)
@Composable
private fun UniADialogTwoLinePreview() {
    UniATwoButtonDialog(
        title = "Dialog message",
        message = "Diaglog message with just OK button\n" +
                "and 2 lines.",
        onClickConfirm = {

        }
    )
}

@Preview(showBackground = true)
@Composable
private fun UniATwoButtonDialogPreview() {
    UniATwoButtonDialog(
        title = "Dialog message",
        message = "Dialog message with just OK button.",
        onClickConfirm = {

        },
        onClickCancel = {

        }
    )
}

@Preview(showBackground = true)
@Composable
private fun UniATwoButtonDialogTwoLinePreview() {
    UniATwoButtonDialog(
        title = "Dialog message",
        message = "Diaglog message with just OK button\n" +
                "and 2 lines.",
        onClickConfirm = {

        },
        onClickCancel = {

        }
    )
}