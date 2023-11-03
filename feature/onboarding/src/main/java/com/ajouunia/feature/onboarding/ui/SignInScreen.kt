package com.ajouunia.feature.onboarding.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavOptions
import com.ajouunia.core.designsystem.Purple4
import com.ajouunia.core.designsystem.component.NonScaleText
import com.ajouunia.core.designsystem.component.UniACheckbox
import com.ajouunia.core.designsystem.component.UniATextField
import com.ajouunia.feature.onboarding.model.SignInUIState
import com.ajouunia.feature.onboarding.vm.ConfirmEmailViewModel.Companion.AJOU_UNIV_DEFAULT_EMAIL_FORM

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    uiState: SignInUIState,
    validInfo: Boolean = false,
    changeInputEmail: (String) -> Unit,
    changeInputPassword: (String) -> Unit,
    changeInputRemember: (Boolean) -> Unit,
    onClickSignIn: () -> Unit,
    navigateToAgreementService: (NavOptions) -> Unit,
    navigateToForgotPassword: (NavOptions) -> Unit,
) {
    val context = LocalContext.current
    
    Log.d("SignInScreen", uiState.toString())

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
            NonScaleText(
                text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_in_title),
                color = Color.Black,
                fontSize = 28.sp,
                fontWeight = FontWeight(700),
                lineHeight = 22.sp,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(50.dp))
            NonScaleText(
                text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_in_title_email),
                color = Color.Black,
                fontSize = 11.sp,
                fontWeight = FontWeight(600),
                lineHeight = 10.sp,
            )
            Row {
                UniATextField(
                    modifier = Modifier.weight(0.5f),
                    value = uiState.id,
                    onValueChange = { newValue ->
                        changeInputEmail(newValue)
                    }
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
                        text = AJOU_UNIV_DEFAULT_EMAIL_FORM,
                        color = Color(0xFF8A8A8A),
                        fontSize = 13.sp,
                        fontWeight = FontWeight(600),
                    )
                }
            }
            Spacer(modifier = Modifier.height(22.dp))
            NonScaleText(
                text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_in_title_password),
                color = Color.Black,
                fontSize = 11.sp,
                fontWeight = FontWeight(600),
                lineHeight = 8.sp,
            )
            UniATextField(
                value = uiState.password,
                onValueChange = { newValue ->
                    changeInputPassword(newValue)
                },
                isPassword = true
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
                        fontSize = 11.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                    )
                ) {
                    changeInputRemember(it)
                }

                NonScaleText(
                    text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_in_title_forgot_password),
                    modifier = Modifier.clickable {
                        val options = NavOptions.Builder().build()
                        navigateToForgotPassword(options)
                    },
                    color = Color.Black,
                    fontSize = 11.sp,
                    fontWeight = FontWeight(600),
                    lineHeight = 8.sp,
                    textAlign = TextAlign.Right,
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 52.dp),
                shape = RoundedCornerShape(size = 10.dp),
                colors = ButtonDefaults.buttonColors(Purple4),
                enabled = validInfo,
                onClick = {
                    onClickSignIn()
                }
            ) {
                NonScaleText(
                    text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_in_btn_sign_in),
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight(600),
                    lineHeight = 8.sp,
                    textAlign = TextAlign.Center,
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 52.dp),
                shape = RoundedCornerShape(size = 10.dp),
                colors = ButtonDefaults.buttonColors(Purple4),
                onClick = {
                    val options = NavOptions.Builder().build()
                    navigateToAgreementService(options)
                }
            ) {
                NonScaleText(
                    text = stringResource(id = com.ajouunia.core.designsystem.R.string.sign_in_btn_sign_up),
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight(600),
                    lineHeight = 8.sp,
                    textAlign = TextAlign.Center,
                )
            }
        }

    }
}

//@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    SignInScreen(
        uiState = SignInUIState.Init,
        changeInputEmail = {},
        changeInputPassword = {},
        changeInputRemember = {},
        onClickSignIn = {},
        navigateToAgreementService = {},
        navigateToForgotPassword = {},
    )
}