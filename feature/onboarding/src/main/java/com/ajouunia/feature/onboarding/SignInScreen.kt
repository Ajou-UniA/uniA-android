package com.ajouunia.feature.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavOptions
import com.ajouunia.core.designsystem.component.UniACheckbox
import com.ajouunia.core.designsystem.component.UniATextField
import com.ajouunia.core.designsystem.urbanistFamily
import com.ajouunia.feature.onboarding.state.SignInUIState

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    uiState: SignInUIState,
    navigateToAgreementService: (NavOptions) -> Unit,
    navigateToForgotPassword: (NavOptions) -> Unit,
    navigateToHome: (NavOptions) -> Unit
) {
    val context = LocalContext.current
    var userEmail by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isRemember by rememberSaveable { mutableStateOf(false) }

    Surface(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp)
                .background(color = Color.White),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_in_title),
                style = TextStyle(
                    fontSize = 30.sp,
                    lineHeight = 22.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_in_title_email),
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
            Spacer(modifier = Modifier.height(22.dp))
            Text(
                text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_in_title_password),
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
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                UniACheckbox(
                    label = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_in_title_remember_account),
                    labelStyle = TextStyle(
                        fontSize = 13.sp,
                        lineHeight = 22.sp,
                        fontFamily = urbanistFamily,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                    )
                ) {
                    //TODO Check
                }

                Text(
                    text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_in_title_forgot_password),
                    style = TextStyle(
                        fontSize = 13.sp,
                        lineHeight = 10.sp,
                        fontFamily = urbanistFamily,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Right,
                    )
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 52.dp),
                shape = RoundedCornerShape(size = 10.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF8354FF)),
                onClick = {
                    // TODO Sign
                }
            ) {
                Text(
                    text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_in_btn_sign_in),
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
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 52.dp),
                shape = RoundedCornerShape(size = 10.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF8354FF)),
                onClick = {
                    val options = NavOptions.Builder().build()
                    navigateToAgreementService(options)
                }
            ) {
                Text(
                    text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_in_btn_sign_up),
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
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    SignInScreen(
        uiState = SignInUIState.Init,
        navigateToAgreementService = {

        },
        navigateToForgotPassword = {

        },
        navigateToHome = {

        }
    )
}