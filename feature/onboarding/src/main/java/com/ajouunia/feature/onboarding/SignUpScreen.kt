package com.ajouunia.feature.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavOptions
import com.ajouunia.core.designsystem.component.UniATextField
import com.ajouunia.core.designsystem.urbanistFamily
import com.ajouunia.feature.onboarding.navigation.SIGN_UP_NAVIGATION_ROUTE

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    navigateToOnBoarding: (NavOptions) -> Unit,
) {
    val scrollState = rememberScrollState()
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var studentId by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(vertical = 50.dp, horizontal = 38.dp)
            .verticalScroll(scrollState),
    ) {
        Text(
            text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_up_title),
            style = TextStyle(
                fontSize = 30.sp,
                lineHeight = 22.sp,
                fontFamily = urbanistFamily,
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
            )
        )
        Spacer(modifier = Modifier.height(35.dp))
        Text(
            text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_up_first_name),
            style = TextStyle(
                fontSize = 13.sp,
                lineHeight = 10.sp,
                fontFamily = urbanistFamily,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
            )
        )
        UniATextField(
            value = firstName,
            onValueChange = { newValue ->
                firstName = newValue
            }
        )
        Spacer(modifier = Modifier.height(22.dp))
        Text(
            text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_up_last_name),
            style = TextStyle(
                fontSize = 13.sp,
                lineHeight = 10.sp,
                fontFamily = urbanistFamily,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
            )
        )
        UniATextField(
            value = lastName,
            onValueChange = { newValue ->
                lastName = newValue
            }
        )
        Spacer(modifier = Modifier.height(22.dp))
        Text(
            text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_up_student_id),
            style = TextStyle(
                fontSize = 13.sp,
                lineHeight = 10.sp,
                fontFamily = urbanistFamily,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
            )
        )
        UniATextField(
            value = studentId,
            onValueChange = { newValue ->
                studentId = newValue
            },
            keyboardType = KeyboardType.Number
        )
        Spacer(modifier = Modifier.height(22.dp))
        Text(
            text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_up_password),
            style = TextStyle(
                fontSize = 13.sp,
                lineHeight = 10.sp,
                fontFamily = urbanistFamily,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
            )
        )
        UniATextField(
            value = password,
            onValueChange = { newValue ->
                password = newValue
            }
        )
        Spacer(modifier = Modifier.height(22.dp))
        Text(
            text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_up_confirm_password),
            style = TextStyle(
                fontSize = 13.sp,
                lineHeight = 10.sp,
                fontFamily = urbanistFamily,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
            )
        )
        UniATextField(
            value = confirmPassword,
            onValueChange = { newValue ->
                confirmPassword = newValue
            }
        )
        Spacer(modifier = Modifier.height(22.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 52.dp),
            shape = RoundedCornerShape(size = 10.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF8354FF)),
            onClick = {
                val options = NavOptions.Builder()
                    .setPopUpTo(SIGN_UP_NAVIGATION_ROUTE, inclusive = true)
                    .build()
                navigateToOnBoarding(options)
            }
        ) {
            Text(
                text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_up_btn_submit),
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
        Spacer(modifier = Modifier.height(15.dp))
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
                    append(stringResource(id = com.ajouunia.core.designsystem.R.string.sign_up_message_first))
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 13.sp,
                        fontFamily = urbanistFamily,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000),
                    )
                ) {
                    append(stringResource(id = com.ajouunia.core.designsystem.R.string.sign_up_message_second))
                }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(navigateToOnBoarding = {})
}
