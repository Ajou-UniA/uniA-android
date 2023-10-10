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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavOptions
import com.ajouunia.core.designsystem.component.UniATextField
import com.ajouunia.core.designsystem.urbanistFamily
import com.ajouunia.feature.onboarding.navigation.CONFIRM_EMAIL_NAVIGATION_ROUTE

@Composable
fun ConfirmEmailScreen(
    modifier: Modifier = Modifier,
    navigateToConfirmEmail: (NavOptions) -> Unit,
) {
    val context = LocalContext.current
    var userEmail by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(vertical = 50.dp, horizontal = 38.dp),
    ) {
        Text(
            text = stringResource(id = com.ajouunia.core.designsystem.R.string.confirm_email_title),
            style = TextStyle(
                fontSize = 30.sp,
                lineHeight = 35.sp,
                fontFamily = urbanistFamily,
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
            )
        )
        Spacer(modifier = Modifier.height(36.dp))
        Text(
            text = "Email",
            style = TextStyle(
                fontSize = 13.sp,
                lineHeight = 10.sp,
                fontFamily = urbanistFamily,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
            )
        )
        UniATextField(
            value = userEmail,
            onValueChange = { newValue ->
                userEmail = newValue
            }
        )
        Spacer(modifier = Modifier.height(42.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 52.dp),
            shape = RoundedCornerShape(size = 10.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF8354FF)),
            onClick = {
                val options = NavOptions.Builder()
                    .setPopUpTo(CONFIRM_EMAIL_NAVIGATION_ROUTE, inclusive = true)
                    .build()
                navigateToConfirmEmail(options)
            }
        ) {
            Text(
                text = stringResource(id = com.ajouunia.core.designsystem.R.string.confirm_email_btn_confirm),
                style = TextStyle(
                    fontSize = 15.sp,
                    lineHeight = 10.sp,
                    fontFamily = urbanistFamily,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                )
            )
        }
        Spacer(modifier = Modifier.height(13.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 13.sp,
                        fontFamily = urbanistFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                ) {
                    append(stringResource(id = com.ajouunia.core.designsystem.R.string.confirm_email_message_first))
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 13.sp,
                        fontFamily = urbanistFamily,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000),
                    )
                ) {
                    append(stringResource(id = com.ajouunia.core.designsystem.R.string.confirm_email_message_verification_code))
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 13.sp,
                        fontFamily = urbanistFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                ) {
                    append(stringResource(id = com.ajouunia.core.designsystem.R.string.confirm_email_message_second))
                }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ConfirmEmailScreenPreview() {
    ConfirmEmailScreen(
        navigateToConfirmEmail = {}
    )
}