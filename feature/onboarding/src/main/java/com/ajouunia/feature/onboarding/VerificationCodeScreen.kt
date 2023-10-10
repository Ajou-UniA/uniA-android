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
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavOptions
import com.ajouunia.core.designsystem.component.OtpTextField
import com.ajouunia.core.designsystem.urbanistFamily
import com.ajouunia.feature.onboarding.navigation.VERIFICATION_CODE_ROUTE
import kotlinx.coroutines.delay

@Composable
fun VerificationCodeScreen(
    modifier: Modifier = Modifier,
    navigateToSignUp: (NavOptions) -> Unit,
) {
    val context = LocalContext.current
    var otpText by rememberSaveable { mutableStateOf("") }
    var isTimeOut by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(vertical = 50.dp, horizontal = 38.dp),
    ) {
        Text(
            text = "Verification Code",
            style = TextStyle(
                fontSize = 30.sp,
                lineHeight = 35.sp,
                fontFamily = urbanistFamily,
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
            )
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Enter code that we have sent to your Ajou University email.",
            style = TextStyle(
                fontSize = 15.sp,
                lineHeight = 15.sp,
                fontFamily = urbanistFamily,
                fontWeight = FontWeight(500),
                color = Color(0xFF000000),
            )
        )
        Spacer(modifier = Modifier.height(45.dp))
        OtpTextField(
            modifier = Modifier.fillMaxWidth(),
            otpText = otpText,
            otpCount = 4,
            onOtpTextChange = { newValue, verificationLength ->
                otpText = newValue
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.Center) {
            Text(
                text = "Time remaining ",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 13.sp,
                    fontFamily = urbanistFamily,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFDF1818),
                )
            )
            Timer(
                duration = 5 * 60 * 1000,
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
            colors = ButtonDefaults.buttonColors(Color(0xFF8354FF)),
            enabled = !isTimeOut,
            onClick = {
                val options = NavOptions.Builder()
                    .setPopUpTo(VERIFICATION_CODE_ROUTE, inclusive = true)
                    .build()
                navigateToSignUp(options)
            }
        ) {
            Text(
                text = "Submit",
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
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Resend Code",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize = 15.sp,
                lineHeight = 13.sp,
                fontFamily = urbanistFamily,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,
            )
        )
    }
}

@Composable
fun Timer(duration: Long, onFinished: () -> Unit) {
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

    Text(
        text = String.format("%02d:%02d", minutes, seconds),
        style = TextStyle(
            fontSize = 12.sp,
            lineHeight = 13.sp,
            fontFamily = urbanistFamily,
            fontWeight = FontWeight(600),
            color = Color(0xFFDF1818),
        )
    )
}

@Preview(showBackground = true)
@Composable
fun VerificationCodeScreenPreview() {
    VerificationCodeScreen(
        navigateToSignUp = {

        }
    )
}