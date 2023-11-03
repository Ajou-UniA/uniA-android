package com.ajouunia.feature.guide.route

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavOptions
import com.ajouunia.feature.guide.ui.GuideScreen
import com.ajouunia.feature.guide.vm.GuideViewModel
import com.ajouunia.core.designsystem.R
import com.ajouunia.core.designsystem.UniAIconPack
import com.ajouunia.core.designsystem.component.NonScaleText
import com.ajouunia.core.designsystem.uniaiconpack.IcHamMenu
import com.ajouunia.core.domain.entity.GuideEntity
import com.ajouunia.feature.guide.ui.GuideTopicMenuDialog
import com.ajouunia.feature.guide.model.GuideUIState

@Composable
internal fun GuideRoute(
    navigateToGuideInfo: (NavOptions, Int, GuideEntity) -> Unit = { _, _, _ -> },
    viewModel: GuideViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        viewModel.getGuideList()
    }
    
    when (val state = uiState) {
        is GuideUIState.Menu -> {
            GuideTopicMenuDialog(
                selectedTopicIndex = state.topicIndex,
                onClickMenu = viewModel::onClickMenuItem
            )
        }
        else -> Unit
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .width(30.dp)
                        .height(34.dp),
                    painter = painterResource(id = R.drawable.icon_logo_1x),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(10.dp))
                NonScaleText(
                    text = "Ajou Guide",
                    fontSize = 18.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(700),
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    imageVector = UniAIconPack.IcHamMenu,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.Black),
                    modifier = Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = viewModel::onClickMenu
                    )
                )
            }
        }
    ) { paddingValues ->
        GuideScreen(
            modifier = Modifier.padding(paddingValues),
            uiState = uiState,
            navigateToGuideInfo = navigateToGuideInfo
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun GuideRoutePreview() {
    GuideRoute()
}