package com.ajouunia.core.designsystem.component

import android.graphics.fonts.FontStyle
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajouunia.core.designsystem.Purple2
import com.ajouunia.core.designsystem.Purple4

@Composable
fun UniACheckbox(
    modifier: Modifier = Modifier,
    label: String,
    labelStyle: TextStyle = LocalTextStyle.current,
    size: Float = 24f,
    checkedColor: Color = Purple2,
    uncheckedColor: Color = Color.White,
    checkmarkColor: Color = Purple4,
    onValueChange: (Boolean) -> Unit
) {

    var isChecked by remember { mutableStateOf(false) }
    val checkboxColor: Color by animateColorAsState(
        if (isChecked) checkedColor else uncheckedColor,
        label = ""
    )
    val density = LocalDensity.current
    val duration = 200
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = modifier.clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {}
            )
    ) {
        Card(
            elevation =  CardDefaults.cardElevation(
                defaultElevation = 0.dp
            ),
            shape = RoundedCornerShape(4.dp),
            border = BorderStroke(
                1.5.dp,
                color = when (isChecked) {
                    true -> checkmarkColor
                    false -> Color(0xFFE3E3E3)
                }
            ),
        ) {
            Box(
                modifier = Modifier
                    .size(size.dp)
                    .background(checkboxColor)
                    .toggleable(
                        value = isChecked,
                        role = Role.Checkbox,
                        onValueChange = {
                            isChecked = !isChecked
                            onValueChange.invoke(isChecked)
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                androidx.compose.animation.AnimatedVisibility(
                    visible = isChecked,
                    enter = slideInHorizontally(
                        animationSpec = tween(duration)
                    ) {
                        with(density) { (size * -0.5).dp.roundToPx() }
                    } + expandHorizontally(
                        expandFrom = Alignment.Start,
                        animationSpec = tween(duration)
                    ),
                    exit = fadeOut()
                ) {
                    Icon(
                        Icons.Default.Check,
                        contentDescription = null,
                        tint = checkmarkColor
                    )
                }
            }
        }
        NonScaleText(
            text = label,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 8.dp),
            color = labelStyle.color,
            fontSize = labelStyle.fontSize,
            fontWeight = labelStyle.fontWeight ?: FontWeight(500),
            lineHeight = labelStyle.lineHeight
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = -1
)
@Composable
fun UniACheckboxPreview() {
    UniACheckbox(
        label = "Remember-me",
        labelStyle = TextStyle(
            fontSize = 13.sp,
            lineHeight = 22.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
        )
    ) {

    }
}