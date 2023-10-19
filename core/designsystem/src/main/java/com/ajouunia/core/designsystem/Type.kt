package com.ajouunia.core.designsystem

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val urbanistFamily = FontFamily(
    Font(R.font.urbanist_black, FontWeight.Black),
    Font(R.font.urbanist_black_italic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.urbanist_bold, FontWeight.Bold),
    Font(R.font.urbanist_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.urbanist_light, FontWeight.Light),
    Font(R.font.urbanist_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.urbanist_thin, FontWeight.Thin),
    Font(R.font.urbanist_thin_italic, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.urbanist_medium, FontWeight.Medium),
    Font(R.font.urbanist_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.urbanist_semi_bold, FontWeight.Normal),
    Font(R.font.urbanist_semi_bold_italic, FontWeight.Normal, FontStyle.Italic),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
//  // Other default text styles to override
//  titleLarge = TextStyle(
//      fontFamily = FontFamily.Default,
//      fontWeight = FontWeight.Normal,
//      fontSize = 22.sp,
//      lineHeight = 28.sp,
//      letterSpacing = 0.sp
//  ),
//  labelSmall = TextStyle(
//      fontFamily = FontFamily.Default,
//      fontWeight = FontWeight.Medium,
//      fontSize = 11.sp,
//      lineHeight = 16.sp,
//      letterSpacing = 0.5.sp
//  )
)