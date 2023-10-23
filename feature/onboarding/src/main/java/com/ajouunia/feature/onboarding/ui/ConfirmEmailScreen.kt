package com.ajouunia.feature.onboarding.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajouunia.core.designsystem.Purple4
import com.ajouunia.core.designsystem.component.NonScaleText
import com.ajouunia.core.designsystem.component.UniATextField
import com.ajouunia.core.designsystem.extensions.nonScaleSp
import com.ajouunia.core.designsystem.urbanistFamily
import com.ajouunia.feature.onboarding.state.ConfirmEmailUIState
import com.ajouunia.feature.onboarding.vm.ConfirmEmailViewModel

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
            fontSize = 28.sp,
            fontWeight = FontWeight(700),
            lineHeight = 33.sp,
        )
        Spacer(modifier = Modifier.height(36.dp))
        NonScaleText(
            text = stringResource(id = com.ajouunia.core.designsystem.R.string.confirm_email_title_email),
            color = Color.Black,
            fontSize = 11.sp,
            fontWeight = FontWeight(600),
            lineHeight = 8.sp,
        )
        Row {
            UniATextField(
                modifier = Modifier.weight(0.5f),
                value = uiState.id,
                onValueChange = changeInputEmail
            )
            Spacer(modifier = Modifier.width(6.dp))
            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .heightIn(min = 52.dp)
                    .background(
                        color = Color(0xffF5F5F5),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = Color(0xffE3E3E3),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(horizontal = 15.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                NonScaleText(
                    text = ConfirmEmailViewModel.AJOU_UNIV_DEFAULT_EMAIL_FORM,
                    color = Color(0xFF8A8A8A),
                    fontSize = 13.sp,
                    fontWeight = FontWeight(600),
                )
            }
        }
        Spacer(modifier = Modifier.height(42.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 52.dp),
            shape = RoundedCornerShape(size = 10.dp),
            colors = ButtonDefaults.buttonColors(Purple4),
            enabled = enableButton,
            onClick = {
                onClickSubmit()
            }
        ) {
            NonScaleText(
                text = stringResource(id = com.ajouunia.core.designsystem.R.string.confirm_email_btn_confirm),
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight(600),
                lineHeight = 8.sp,
                textAlign = TextAlign.Center,
            )
        }
        Spacer(modifier = Modifier.height(13.dp))

        val textFirst = stringResource(id = com.ajouunia.core.designsystem.R.string.confirm_email_message_first)
        val textSecond = stringResource(id = com.ajouunia.core.designsystem.R.string.confirm_email_message_verification_code)
        val textThird = stringResource(id = com.ajouunia.core.designsystem.R.string.confirm_email_message_second)
        val fontSize = 10.sp.nonScaleSp

        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = ParagraphStyle(lineHeight = 14.sp.nonScaleSp)
                ) {
                    withStyle(
                        style = SpanStyle(
                            fontSize = fontSize,
                            fontFamily = urbanistFamily,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),
                        )
                    ) {
                        append(textFirst)
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = fontSize,
                            fontFamily = urbanistFamily,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF000000),
                        )
                    ) {
                        append(textSecond)
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = fontSize,
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