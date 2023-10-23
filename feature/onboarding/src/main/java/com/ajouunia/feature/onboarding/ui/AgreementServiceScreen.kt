package com.ajouunia.feature.onboarding.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavOptions
import com.ajouunia.core.designsystem.Purple4
import com.ajouunia.core.designsystem.R
import com.ajouunia.core.designsystem.UniAIconPack
import com.ajouunia.core.designsystem.component.NonScaleText
import com.ajouunia.core.designsystem.uniaiconpack.IconArrow
import com.ajouunia.core.designsystem.uniaiconpack.IconCheckedEllipse
import com.ajouunia.core.designsystem.uniaiconpack.IconUncheckEllipse
import com.ajouunia.feature.onboarding.navigation.AGREEMENT_SERVICE_NAVIGATION_ROUTE
import com.ajouunia.feature.onboarding.state.AgreementServiceUIState

@Composable
fun AgreementServiceScreen(
    modifier: Modifier = Modifier,
    uiState: AgreementServiceUIState,
    changeInputTermsOfUse: () -> Unit = {},
    changeInputPrivacyPolicy: () -> Unit = {},
    navigateToConfirmEmail: (NavOptions) -> Unit,
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(bottom = 20.dp, start = 38.dp, end = 38.dp),
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        NonScaleText(
            text = stringResource(id = R.string.agreement_service_title),
            color = Color.Black,
            fontSize = 28.sp,
            fontWeight = FontWeight(700),
            lineHeight = 33.sp,
        )
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    imageVector = when (uiState.acceptTermsOfUse) {
                        true -> UniAIconPack.IconCheckedEllipse
                        false -> UniAIconPack.IconUncheckEllipse
                    },
                    contentDescription = null,
                    modifier = Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = changeInputTermsOfUse
                    )
                )
                Row {
                    NonScaleText(
                        text = stringResource(id = R.string.agreement_service_agree_message),
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(600),
                        color = Color.Black,
                        fontSize = 13.sp,
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    NonScaleText(
                        text = stringResource(id = R.string.agreement_service_terms),
                        fontSize = 13.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(600),
                        color = Purple4,
                    )
                }
                Image(
                    imageVector = UniAIconPack.IconArrow,
                    contentDescription = null,
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    imageVector = when (uiState.acceptPrivacyPolicy) {
                        true -> UniAIconPack.IconCheckedEllipse
                        false -> UniAIconPack.IconUncheckEllipse
                    },
                    contentDescription = null,
                    modifier = Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = changeInputPrivacyPolicy
                    )
                )
                Row {
                    NonScaleText(
                        text = stringResource(id = R.string.agreement_service_agree_message),
                        fontSize = 13.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    NonScaleText(
                        text = stringResource(id = R.string.agreement_service_privacy),
                        fontSize = 13.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(600),
                        color = Purple4,
                    )
                }
                Image(
                    imageVector = UniAIconPack.IconArrow,
                    contentDescription = null,
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 52.dp),
                shape = RoundedCornerShape(size = 10.dp),
                colors = ButtonDefaults.buttonColors(Purple4),
                enabled = uiState.acceptTermsOfUse and uiState.acceptPrivacyPolicy,
                onClick = {
                    val options = NavOptions.Builder()
                        .setPopUpTo(AGREEMENT_SERVICE_NAVIGATION_ROUTE, inclusive = true)
                        .build()
                    navigateToConfirmEmail(options)
                }
            ) {
                NonScaleText(
                    text = stringResource(id = R.string.agreement_service_agree),
                    fontSize = 13.sp,
                    lineHeight = 8.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AgreementServiceScreenPreview() {
    AgreementServiceScreen(
        uiState = AgreementServiceUIState.UpdateInfo(
            acceptTermsOfUse = true,
            acceptPrivacyPolicy = false
        ),
        navigateToConfirmEmail = {}
    )
}