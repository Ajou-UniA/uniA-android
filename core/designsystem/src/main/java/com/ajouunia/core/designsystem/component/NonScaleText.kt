package com.ajouunia.core.designsystem.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.ajouunia.core.designsystem.extensions.nonScaleSp
import com.ajouunia.core.designsystem.urbanistFamily

@Composable
fun NonScaleText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
) = Text(
    text = text,
    modifier = modifier,
    color = color,
    fontSize = fontSize.nonScaleSp,
    fontWeight = fontWeight,
    fontFamily = urbanistFamily,
    letterSpacing = letterSpacing.nonScaleSp,
    textAlign = textAlign,
    lineHeight = lineHeight.nonScaleSp,
)

@Preview(showBackground = true)
@Composable
fun NonScaleTextPreview() {
    NonScaleText(
        text = "test",
        color = Color.White,
        fontSize = 13.sp,
        fontWeight = FontWeight(500)
    )
}