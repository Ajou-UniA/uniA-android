package com.ajouunia.feature.onboarding

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajouunia.core.designsystem.Purple4
import com.ajouunia.core.designsystem.R
import com.ajouunia.core.designsystem.component.NonScaleText
import com.ajouunia.core.designsystem.component.OtpTextField
import com.ajouunia.feature.onboarding.state.VerificationCodeUIState
import kotlinx.coroutines.delay

private const val DEFAULT_DURATION: Long = 5L * 60L * 1000L

@Composable
fun VerificationCodeScreen(
    modifier: Modifier = Modifier,
    userEmail: String = "",
    uiState: VerificationCodeUIState,
    changeInputCode: (String) -> Unit,
    onClickSubmit: (String) -> Unit,
    onClickResend: (String) -> Unit
) {
    val context = LocalContext.current
    var isTimeOut by rememberSaveable { mutableStateOf(false) }
    var duration by rememberSaveable { mutableLongStateOf(DEFAULT_DURATION) }

    if (uiState is VerificationCodeUIState.Resend) {
        duration = DEFAULT_DURATION
    }
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(vertical = 50.dp, horizontal = 38.dp),
    ) {
        NonScaleText(
            text = stringResource(id = R.string.verification_code_title),
            fontSize = 28.sp,
            lineHeight = 33.sp,
            color = Color.Black,
            fontWeight = FontWeight(700)
        )
        Spacer(modifier = Modifier.height(15.dp))
        NonScaleText(
            text = stringResource(id = R.string.verification_code_message),
            color = Color.Black,
            fontSize = 13.sp,
            fontWeight = FontWeight(500),
            lineHeight = 13.sp
        )
        Spacer(modifier = Modifier.height(45.dp))
        OtpTextField(
            modifier = Modifier.fillMaxWidth(),
            otpText = uiState.code,
            otpCount = 4,
            onOtpTextChange = { newValue, verificationLength ->
                changeInputCode(newValue)
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.Center) {
            NonScaleText(
                text = stringResource(id = R.string.verification_code_message_time),
                color = Color(0xFFDF1818),
                fontSize = 10.sp,
                fontWeight = FontWeight(600),
                lineHeight = 11.sp,
            )
            Spacer(modifier = Modifier.width(5.dp))
            Timer(
                duration = duration,
                onFinished = {
                    isTimeOut = true
                }
            )
        }
        Spacer(modifier = Modifier.height(27.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 52.dp),
            shape = RoundedCornerShape(size = 10.dp),
            colors = ButtonDefaults.buttonColors(Purple4),
            enabled = !isTimeOut,
            onClick = {
                onClickSubmit(userEmail)
            }
        ) {
            NonScaleText(
                text = stringResource(id = R.string.verification_code_btn_submit),
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight(600),
                textAlign = TextAlign.Center,
                lineHeight = 8.sp,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        NonScaleText(
            text = stringResource(id = R.string.verification_code_btn_resend),
            modifier = Modifier.fillMaxWidth()
                .clickable { onClickResend(userEmail) },
            color = Color.Black,
            fontSize = 13.sp,
            fontWeight = FontWeight(600),
            textAlign = TextAlign.Center,
            lineHeight = 11.sp,
        )
    }
}

@Composable
fun Timer(
    duration: Long,
    onFinished: () -> Unit
) {
    var currentTimerValue by remember(duration) { mutableLongStateOf(duration) }

    LaunchedEffect(key1 = currentTimerValue) {
        if (currentTimerValue > 0) {
            delay(1000L)
            currentTimerValue -= 1000L
        } else {
            onFinished.invoke()
        }
    }

    val secMilSec: Long = 1000
    val minMilSec = 60 * secMilSec

    val minutes = (currentTimerValue / minMilSec)
    val seconds = (currentTimerValue % minMilSec / secMilSec)

    NonScaleText(
        text = String.format("%02d:%02d", minutes, seconds),
        color = Color(0xFFDF1818),
        fontSize = 10.sp,
        fontWeight = FontWeight(600),
        lineHeight = 11.sp,
    )
}

@Preview(showBackground = true)
@Composable
fun VerificationCodeScreenPreview() {
    VerificationCodeScreen(
        uiState = VerificationCodeUIState.Init,
        changeInputCode = {},
        onClickSubmit = {},
        onClickResend = {}
    )
}