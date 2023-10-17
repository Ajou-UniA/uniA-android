package com.ajouunia.feature.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajouunia.core.designsystem.component.NonScaleText
import com.ajouunia.core.designsystem.component.UniATextField
import com.ajouunia.core.designsystem.extensions.nonScaleSp
import com.ajouunia.core.designsystem.urbanistFamily
import com.ajouunia.feature.onboarding.state.ConfirmEmailUIState

@Composable
fun ConfirmEmailScreen(
    modifier: Modifier = Modifier,
    uiState: ConfirmEmailUIState,
    changeInputEmail: (String) -> Unit,
    enableButton: Boolean,
    onClickSubmit: () -> Unit,
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(vertical = 50.dp, horizontal = 38.dp),
    ) {
        NonScaleText(
            text = stringResource(id = com.ajouunia.core.designsystem.R.string.confirm_email_title),
            color = Color.Black,
            fontSize = 30.sp,
            fontWeight = FontWeight(700),
            lineHeight = 35.sp,
        )
        Spacer(modifier = Modifier.height(36.dp))
        NonScaleText(
            text = stringResource(id = com.ajouunia.core.designsystem.R.string.confirm_email_title_email),
            color = Color.Black,
            fontSize = 13.sp,
            fontWeight = FontWeight(600),
            lineHeight = 10.sp,
        )
        UniATextField(
            value = uiState.email,
            onValueChange = changeInputEmail
        )
        Spacer(modifier = Modifier.height(42.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 52.dp),
            shape = RoundedCornerShape(size = 10.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF8354FF)),
            enabled = enableButton,
            onClick = {
                onClickSubmit()
            }
        ) {
            NonScaleText(
                text = stringResource(id = com.ajouunia.core.designsystem.R.string.confirm_email_btn_confirm),
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight(600),
                lineHeight = 10.sp,
                textAlign = TextAlign.Center,
            )
        }
        Spacer(modifier = Modifier.height(13.dp))

        val textFirst = stringResource(id = com.ajouunia.core.designsystem.R.string.confirm_email_message_first)
        val textSecond = stringResource(id = com.ajouunia.core.designsystem.R.string.confirm_email_message_verification_code)
        val textThird = stringResource(id = com.ajouunia.core.designsystem.R.string.confirm_email_message_second)

        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = ParagraphStyle(lineHeight = 14.sp.nonScaleSp)
                ) {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 12.sp,
                            fontFamily = urbanistFamily,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),
                        )
                    ) {
                        append(textFirst)
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = 12.sp,
                            fontFamily = urbanistFamily,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF000000),
                        )
                    ) {
                        append(textSecond)
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = 12.sp,
                            fontFamily = urbanistFamily,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),
                        )
                    ) {
                        append(textThird)
                    }
                }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ConfirmEmailScreenEnablePreview() {
    ConfirmEmailScreen(
        uiState = ConfirmEmailUIState.Init,
        changeInputEmail = {},
        enableButton = true,
        onClickSubmit = {},
    )
}

@Preview(showBackground = true)
@Composable
fun ConfirmEmailScreenDisablePreview() {
    ConfirmEmailScreen(
        uiState = ConfirmEmailUIState.Init,
        changeInputEmail = {},
        enableButton = false,
        onClickSubmit = {},
    )
}