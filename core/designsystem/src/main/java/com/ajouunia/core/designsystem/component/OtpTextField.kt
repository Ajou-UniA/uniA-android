package com.ajouunia.core.designsystem.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.ajouunia.core.designsystem.Purple4
import com.ajouunia.core.designsystem.urbanistFamily

@Composable
fun OtpTextField(
    modifier: Modifier = Modifier,
    otpText: String,
    otpCount: Int = 6,
    onOtpTextChange: (String, Boolean) -> Unit
) {
    LaunchedEffect(Unit) {
        if (otpText.length > otpCount) {
            throw IllegalArgumentException("Otp text value must not have more than otpCount: $otpCount characters")
        }
    }

    BasicTextField(
        modifier = modifier,
        value = TextFieldValue(otpText, selection = TextRange(otpText.length)),
        onValueChange = {
            if (it.text.length <= otpCount && it.text.isDigitsOnly()) {
                onOtpTextChange.invoke(it.text, it.text.length == otpCount)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        decorationBox = {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                repeat(otpCount) { index ->
                    CharView(
                        index = index,
                        text = otpText
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    )
}

@Composable
private fun CharView(
    index: Int,
    text: String
) {
    val isFocused = text.length == index
    val char = when {
        index == text.length -> ""
        index > text.length -> ""
        else -> text[index].toString()
    }
    Text(
        modifier = Modifier
            .width(65.dp)
            .height(48.dp)
            .border(
                width = 1.dp,
                color = when {
                    isFocused -> Purple4
                    else -> Color(0xFFE3E3E3)
                },
                shape = RoundedCornerShape(8.dp)
            )
            .padding(2.dp),
        text = char,
        style = TextStyle(
            fontSize = 30.sp,
            lineHeight = 22.sp,
            fontFamily = urbanistFamily,
            fontWeight = FontWeight(700),
            color = Color(0xFF000000),
        ),
        color = if (isFocused) {
            Color(0xFFB5B6BA)
        } else {
            Color(0xFF60626C)
        },
        textAlign = TextAlign.Center
    )
}

@Preview(
    showBackground = true,
    backgroundColor = -1
)
@Composable
fun OtpTextFieldPreview() {
    OtpTextField(
        otpText = "",
        otpCount = 4,
        onOtpTextChange = { _, _ -> }
    )
}

@Preview(
    showBackground = true,
    backgroundColor = -1
)
@Composable
fun CharViewPreview() {
    CharView(
        index = 0,
        text = "0"
    )
}