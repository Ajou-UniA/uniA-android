package com.ajouunia.feature.onboarding.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajouunia.core.designsystem.Purple4
import com.ajouunia.core.designsystem.R
import com.ajouunia.core.designsystem.UniAIconPack
import com.ajouunia.core.designsystem.component.NonScaleText
import com.ajouunia.core.designsystem.uniaiconpack.IconLogoName

@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    navigateToBack: () -> Unit
) {
    val context = LocalContext.current

    Surface(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 40.dp),
    ) {
        val logo = painterResource(R.drawable.icon_logo_1x)
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            NonScaleText(
                text = stringResource(id = R.string.on_boarding_title),
                color = Color.Black,
                fontSize = 28.sp,
                fontWeight = FontWeight(700),
                lineHeight = 20.sp,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(130.dp))
            Image(
                painter = logo,
                contentDescription = null,
                modifier = Modifier.scale(2.0f)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Image(
                imageVector = UniAIconPack.IconLogoName,
                contentDescription = null,
            )

            Spacer(modifier = Modifier.height(100.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 52.dp),
                shape = RoundedCornerShape(size = 10.dp),
                colors = ButtonDefaults.buttonColors(Purple4),
                onClick = {
                    navigateToBack()
                }
            ) {
                NonScaleText(
                    text = stringResource(id = R.string.on_boarding_btn_sign_in),
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

@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen {

    }
}