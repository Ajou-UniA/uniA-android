package com.ajouunia.feature.task.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.ajouunia.core.designsystem.Purple4
import com.ajouunia.core.designsystem.component.NonScaleText
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

private val hourFormatter by lazy {
    DateTimeFormatter.ofPattern("HH")
}

private val minFormatter by lazy {
    DateTimeFormatter.ofPattern("mm")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskTimePickerDialog(
    title: String = "Select Time",
    dateTime: LocalDateTime,
    isCreateMode: Boolean = false,
    onCancel: () -> Unit,
    onConfirm: (Int, Int) -> Unit,
    toggle: @Composable () -> Unit = {},
) {
    val hour: Int = kotlin.runCatching {
        dateTime.format(hourFormatter).toInt()
    }.getOrDefault(9)

    val min: Int = kotlin.runCatching {
        dateTime.format(minFormatter).toInt()
    }.getOrDefault(0)

    val timePickerState = rememberTimePickerState(
        initialHour = hour,
        initialMinute = min,
        is24Hour = false
    )

    Dialog(
        onDismissRequest = onCancel,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(8.dp),
            color = Color.White,
            shape = ShapeDefaults.ExtraLarge,
            tonalElevation = 6.dp,
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
                    .background(Color.Transparent),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NonScaleText(
                    text = title,
                    color = Color.Black,
                    fontSize = 13.sp,
                    fontWeight = FontWeight(500),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                )
                TimePicker(
                    state = timePickerState,
                    colors = TimePickerDefaults.colors(
                        clockDialColor = Color.White,
                        clockDialSelectedContentColor = Color.White,
                        clockDialUnselectedContentColor = Color.Black,
                        selectorColor = Color(0xFFDABEFF),
                        containerColor = Color.White,
                        periodSelectorBorderColor = Color.Black,
                        periodSelectorSelectedContainerColor = Color(0xFFDABEFF),
                        periodSelectorUnselectedContainerColor = Color.White,
                        periodSelectorSelectedContentColor = Color.White,
                        periodSelectorUnselectedContentColor = Color.Black,
                        timeSelectorSelectedContainerColor = Color(0xFFDABEFF),
                        timeSelectorUnselectedContainerColor = Color.White,
                        timeSelectorSelectedContentColor = Color.White,
                        timeSelectorUnselectedContentColor = Color.Black,
                    ),
                    layoutType = TimePickerLayoutType.Vertical
                )
                Row(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth()
                        .background(Color.Transparent)
                ) {
                    toggle()
                    Spacer(modifier = Modifier.weight(1f))
                    TextButton(onClick = onCancel) {
                        NonScaleText(
                            text = "Cancel",
                            color = Color.Black,
                            fontSize = 13.sp,
                            fontWeight = FontWeight(500)
                        )
                    }
                    TextButton(
                        onClick = {
                            onConfirm(timePickerState.hour, timePickerState.minute)
                        }
                    ) {
                        NonScaleText(
                            text = "OK",
                            color = Color.Black,
                            fontSize = 13.sp,
                            fontWeight = FontWeight(500)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskTimePickerDialogPreview() {
    val dateString = "2023-09-20T23:59:00"

    val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
    val dateTime = LocalDateTime.parse(dateString, dateTimeFormatter)

    TaskTimePickerDialog(
        dateTime = dateTime,
        onCancel = {},
        onConfirm = { _, _ -> }
    )
}