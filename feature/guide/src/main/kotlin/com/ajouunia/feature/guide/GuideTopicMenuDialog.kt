package com.ajouunia.feature.guide

import android.view.Gravity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogWindowProvider
import com.ajouunia.core.designsystem.Purple4
import com.ajouunia.core.designsystem.R
import com.ajouunia.core.designsystem.component.NonScaleText

internal val menuList by lazy {
    listOf(
        "Ajou Campus Life",
        "Academic Affairs",
        "Immigration Guide"
    )
}

@Composable
fun GuideTopicMenuDialog(
    modifier: Modifier = Modifier,
    selectedTopicIndex: Int,
    onClickMenu: (Int) -> Unit
) {
    val context = LocalContext.current

    Dialog(
        onDismissRequest = {}
    ) {
        val dialogWindowProvider = LocalView.current.parent as DialogWindowProvider
        dialogWindowProvider.window.setGravity(Gravity.RIGHT)

        Column(
            modifier = modifier
                .fillMaxHeight()
                .width(200.dp)
                .background(Color.White)
                .padding(horizontal = 15.dp, vertical = 75.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width(30.dp)
                    .height(34.dp),
                painter = painterResource(id = R.drawable.icon_logo_1x),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(90.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(menuList.size) { index ->
                    GuideTopicMenuItemScreen(
                        modifier = Modifier.clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = {
                                onClickMenu(index)
                            }
                        ),
                        isSelected = index == selectedTopicIndex,
                        title = menuList[index],
                    )
                }
            }

        }
    }
}

@Composable
fun GuideTopicMenuItemScreen(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    title: String,
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .background(
            color = when (isSelected) {
                true -> Color(0xFFF5F5F5)
                false -> Color.White
            },
            shape = RoundedCornerShape(size = 10.dp)
        )
        .padding(15.dp),
) {
    NonScaleText(
        text = title,
        color = when (isSelected) {
            true -> Purple4
            false -> Color(0xFF8A8A8A)
        },
        fontSize = 13.sp,
        fontWeight = FontWeight(700)
    )
}

//@Preview(showBackground = true)
@Composable
fun GuideTopicMenuDialogPreview() {
    GuideTopicMenuDialog(
        selectedTopicIndex = 0,
        onClickMenu = {}
    )
}

//@Preview(showBackground = true)
@Composable
fun GuideTopicMenuItemScreenPreview() {
    GuideTopicMenuItemScreen(
        isSelected = true,
        title = "Ajou Campuse Life"
    )
}