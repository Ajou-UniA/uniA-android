package com.ajouunia.feature.task.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajouunia.core.designsystem.Blue2
import com.ajouunia.core.designsystem.Purple4
import com.ajouunia.core.designsystem.component.NonScaleText
import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TaskDatePickerDialog(
    initialSelectedDateMillis: Long,
    isCreateMode: Boolean = false,
    onClickCancel: () -> Unit,
    onClickConfirm: (LocalDateTime) -> Unit
) {
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = initialSelectedDateMillis
    )

    val defaultColor = DatePickerDefaults.colors(
        containerColor = Color.White,
        yearContentColor = Color.Black,
        currentYearContentColor = when (isCreateMode) {
            true -> Purple4
            false -> Blue2
        },
        selectedYearContentColor = Color.White,
        selectedYearContainerColor = when (isCreateMode) {
            true -> Purple4
            false -> Blue2
        },
        dayContentColor = Color.Black,
        disabledDayContentColor = when (isCreateMode) {
            true -> Purple4
            false -> Blue2
        },
        selectedDayContentColor = Color.White,
        disabledSelectedDayContentColor = when (isCreateMode) {
            true -> Purple4
            false -> Blue2
        },
        selectedDayContainerColor= when (isCreateMode) {
            true -> Purple4
            false -> Blue2
        },
        disabledSelectedDayContainerColor = when (isCreateMode) {
            true -> Purple4
            false -> Blue2
        },
        todayContentColor = when (isCreateMode) {
            true -> Purple4
            false -> Blue2
        },
        todayDateBorderColor = when (isCreateMode) {
            true -> Purple4
            false -> Blue2
        },
    )

    DatePickerDialog(
        onDismissRequest = {},
        dismissButton = {
            TextButton(onClick = onClickCancel) {
                NonScaleText(
                    text = "Cancel",
                    color = Color.Black,
                    fontSize = 13.sp,
                    fontWeight = FontWeight(500)
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    datePickerState.selectedDateMillis?.let { selected ->
                        onClickConfirm(
                            Instant.ofEpochMilli(selected).atZone(ZoneId.of("Asia/Seoul")).toLocalDateTime()
                        )
                    }
                }
            ) {
                NonScaleText(
                    text = "OK",
                    color = Color.Black,
                    fontSize = 13.sp,
                    fontWeight = FontWeight(500)
                )
            }
        },
        shape = RoundedCornerShape(10.dp),
        colors = defaultColor
    ) {
        DatePicker(
            state = datePickerState,
            showModeToggle = false,
            title = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    NonScaleText(
                        text = "Select date",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500)
                    )
                }
            },
            colors = defaultColor
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TaskDatePickerDialogPreview() {
    TaskDatePickerDialog(
        initialSelectedDateMillis = -1L,
        onClickCancel = {},
        onClickConfirm = {},
    )
}