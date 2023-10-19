package com.ajouunia.feature.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavOptions
import com.ajouunia.core.designsystem.R
import com.ajouunia.core.designsystem.component.NonScaleText
import com.ajouunia.core.designsystem.component.UniATextField
import com.ajouunia.core.designsystem.extensions.nonScaleSp
import com.ajouunia.core.designsystem.urbanistFamily
import com.ajouunia.feature.onboarding.navigation.SIGN_UP_NAVIGATION_ROUTE
import com.ajouunia.feature.onboarding.state.SignUpUiState

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    uiState: SignUpUiState,
    navigateToOnBoarding: (NavOptions) -> Unit,
    changeInputFirstName: (String) -> Unit = {},
    changeInfoLastName: (String) -> Unit = {},
    changeInfoStudentId: (String) -> Unit = {},
    onClickDepartment: () -> Unit = {},
    changeInfoPassword: (String) -> Unit = {},
    changeInfoConfirmPassword: (String) -> Unit = {},
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(vertical = 50.dp, horizontal = 38.dp)
            .verticalScroll(scrollState),
    ) {
        NonScaleText(
            text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_up_title),
            color = Color.Black,
            fontSize = 28.sp,
            fontWeight = FontWeight(700),
            lineHeight = 20.sp
        )
        Spacer(modifier = Modifier.height(35.dp))
        NonScaleText(
            text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_up_first_name),
            fontSize = 11.sp,
            lineHeight = 8.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
        )
        UniATextField(
            value = uiState.infoState.firstName,
            onValueChange = { newValue ->
                changeInputFirstName(newValue)
            }
        )
        Spacer(modifier = Modifier.height(22.dp))
        NonScaleText(
            text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_up_last_name),
            fontSize = 11.sp,
            lineHeight = 8.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
        )
        UniATextField(
            value = uiState.infoState.lastName,
            onValueChange = { newValue ->
                changeInfoLastName(newValue)
            }
        )
        Spacer(modifier = Modifier.height(22.dp))
        NonScaleText(
            text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_up_student_id),
            fontSize = 11.sp,
            lineHeight = 8.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
        )
        UniATextField(
            value = uiState.infoState.studentId,
            onValueChange = { newValue ->
                changeInfoStudentId(newValue)
            },
            keyboardType = KeyboardType.Number
        )
        Spacer(modifier = Modifier.height(22.dp))

        NonScaleText(
            text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_up_department),
            fontSize = 11.sp,
            lineHeight = 8.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
        )

        UniATextField(
            value = uiState.infoState.department,
            onValueChange = { _ -> },
            enable = false,
            modifier = Modifier.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {
                    onClickDepartment()
                }
            ),
        )
        Spacer(modifier = Modifier.height(22.dp))

        NonScaleText(
            text = stringResource(id = R.string.sign_up_password),
            fontSize = 11.sp,
            lineHeight = 8.sp,
            fontWeight = FontWeight(600),
            color = when (uiState.infoState.isValidPassword) {
                true -> Color(0xFF21D749)
                false -> when (uiState.infoState.password.isEmpty()) {
                    true -> Color(0xFF000000)
                    false -> Color.Red
                }
            },
        )
        UniATextField(
            value = uiState.infoState.password,
            onValueChange = { newValue ->
                changeInfoPassword(newValue)
            },
            isPassword = true,
            error = when (uiState.infoState.isValidPassword) {
                true -> null
                false -> when (uiState.infoState.password.isEmpty()) {
                    true -> null
                    false -> "Your password must contain at least 8 characthers and 1 special characther."
                }
            },
            success = when (uiState.infoState.isValidPassword) {
                true -> "Your password is great."
                false -> null
            }
        )
        Spacer(modifier = Modifier.height(22.dp))
        NonScaleText(
            text = stringResource(id = R.string.sign_up_confirm_password),
            fontSize = 11.sp,
            lineHeight = 8.sp,
            fontWeight = FontWeight(600),
            color = when (uiState.infoState.isValidConfirmPassword) {
                true -> Color(0xFF21D749)
                false -> when (uiState.infoState.confirmPassword.isEmpty()) {
                    true -> Color(0xFF000000)
                    false -> Color.Red
                }
            },
        )
        UniATextField(
            value = uiState.infoState.confirmPassword,
            onValueChange = { newValue ->
                changeInfoConfirmPassword(newValue)
            },
            isPassword = true,
            error = when (uiState.infoState.isValidConfirmPassword) {
                true -> null
                false -> when (uiState.infoState.confirmPassword.isEmpty()) {
                    true -> null
                    false -> "The password does not match."
                }
            },
            success = when (uiState.infoState.isValidConfirmPassword) {
                true -> "Your password is great."
                false -> null
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
            NonScaleText(
                text = stringResource(id = R.string.sign_up_btn_submit),
                fontSize = 13.sp,
                lineHeight = 8.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 11.sp.nonScaleSp,
                        fontFamily = urbanistFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                ) {
                    append(stringResource(id = R.string.sign_up_message_first))
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 11.sp.nonScaleSp,
                        fontFamily = urbanistFamily,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000),
                    )
                ) {
                    append(stringResource(id = R.string.sign_up_message_second))
                }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(
        uiState = SignUpUiState.Init,
        navigateToOnBoarding = {}
    )
}
