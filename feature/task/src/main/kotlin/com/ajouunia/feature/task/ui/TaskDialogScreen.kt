package com.ajouunia.feature.task.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerFormatter
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.ajouunia.core.designsystem.Blue4
import com.ajouunia.core.designsystem.Purple4
import com.ajouunia.core.designsystem.component.NonScaleText
import com.ajouunia.core.designsystem.component.UniATextField
import com.ajouunia.feature.task.state.TaskState
import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId
import org.threeten.bp.format.DateTimeFormatter
import java.util.Locale

private val dateFormatter by lazy {
    DateTimeFormatter.ofPattern("dd")
}

private val monthFormatter by lazy {
    DateTimeFormatter.ofPattern("MM")
}

private val yearFormatter by lazy {
    DateTimeFormatter.ofPattern("yyyy")
}

private val timeFormatter by lazy {
    DateTimeFormatter.ofPattern("hh:mm a").withLocale(Locale.US)
}

@Composable
fun TaskDialogScreen(
    modifier: Modifier = Modifier,
    taskState: TaskState,
    changeInputCourseName: (String, Boolean) -> Unit = { _, _ -> },
    changeInputTaskName: (String, Boolean) -> Unit = { _, _ -> },
    changeInputDate: (LocalDateTime, Boolean) -> Unit = { _, _ -> },
    changeInputTime: (Int, Int, Boolean) -> Unit = { _, _, _ -> },
    onClickSave: (Boolean) -> Unit = {},
    onClickCancel: () -> Unit = {},
    isCreateMode: Boolean = false
) {
    val day: String = taskState.deadLine.format(dateFormatter)
    val month: String = changeMonthFormat(taskState.deadLine.format(monthFormatter))
    val year: String = taskState.deadLine.format(yearFormatter)
    val time: String = taskState.deadLine.format(timeFormatter)

    var isActiveDatePopUp by remember { mutableStateOf(false) }
    var isActiveTimePopUp by remember { mutableStateOf(false) }

    if (isActiveDatePopUp) {
        TaskDatePickerDialog(
            initialSelectedDateMillis = taskState.deadLine.atZone(ZoneId.of("Asia/Seoul")).toInstant().toEpochMilli(),
            isCreateMode = isCreateMode,
            onClickCancel = {
                isActiveDatePopUp = false
            },
            onClickConfirm = {
                changeInputDate(it, isCreateMode)
                isActiveDatePopUp = false
            },
        )
    }

    if (isActiveTimePopUp) {
        TaskTimePickerDialog(
            dateTime = taskState.deadLine,
            isCreateMode = isCreateMode,
            onCancel = {
                isActiveTimePopUp = false
            },
            onConfirm = { hour: Int, minute: Int ->
                changeInputTime(hour, minute, isCreateMode)
                isActiveTimePopUp = false
            }
        )
    }

    Dialog(onDismissRequest = {}) {
        Column(
            modifier = modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(size = 20.dp)
                )
                .padding(horizontal = 20.dp, vertical = 25.dp)
        ) {
            NonScaleText(
                text = "Course name",
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight(600)
            )
            Spacer(modifier = Modifier.height(7.dp))
            UniATextField(
                value = taskState.courseName,
                onValueChange = { changeInputCourseName(it, isCreateMode) },
                error = null
            )
            Spacer(modifier = Modifier.height(10.dp))
            NonScaleText(
                text = "Task name",
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight(600)
            )
            Spacer(modifier = Modifier.height(7.dp))
            UniATextField(
                value = taskState.taskName,
                onValueChange = { changeInputTaskName(it, isCreateMode) },
                error = null
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    NonScaleText(
                        text = "Select a due date",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(600)
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                    Row(
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color(0xFFE3E3E3),
                                shape = RoundedCornerShape(size = 10.dp)
                            )
                            .widthIn(max = 160.dp)
                            .heightIn(min = 52.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(size = 10.dp)
                            )
                            .padding(horizontal = 13.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = {
                                    isActiveDatePopUp = true
                                }
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        NonScaleText(
                            text = "$day $month, $year",
                            color = Color(0xFF8A8A8A),
                            fontSize = 10.sp,
                            fontWeight = FontWeight(600),
                            modifier = Modifier.weight(1f),
                            maxLines = 1
                        )
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowDown,
                            contentDescription = null,
                            tint = when (isCreateMode) {
                                true -> Purple4
                                false -> Blue4
                            },
                        )
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    NonScaleText(
                        text = "Select a time",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(600)
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                    Row(
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color(0xFFE3E3E3),
                                shape = RoundedCornerShape(size = 10.dp)
                            )
                            .widthIn(min = 80.dp, max = 109.dp)
                            .heightIn(min = 52.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(size = 10.dp)
                            )
                            .padding(horizontal = 15.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = {
                                    isActiveTimePopUp = true
                                }
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        NonScaleText(
                            text = time,
                            color = Color(0xFF8A8A8A),
                            fontSize = 10.sp,
                            fontWeight = FontWeight(600),
                            modifier = Modifier.weight(1f),
                            maxLines = 1
                        )
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowDown,
                            contentDescription = null,
                            tint = when (isCreateMode) {
                                true -> Purple4
                                false -> Blue4
                            },
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .weight(0.4f)
                        .border(
                            width = 1.dp,
                            color = when (isCreateMode) {
                                true -> Purple4
                                false -> Blue4
                            },
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(horizontal = 20.dp, vertical = 15.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = onClickCancel
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    NonScaleText(
                        text = "Cancel",
                        color = when (isCreateMode) {
                            true -> Purple4
                            false -> Blue4
                        },
                        fontSize = 15.sp,
                        fontWeight = FontWeight(600)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Box(
                    modifier = Modifier
                        .weight(0.6f)
                        .background(
                            color = when (isCreateMode) {
                                true -> Color(0xFFDABEFF)
                                false -> Color(0xFFE2F7FF)
                            },
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(horizontal = 20.dp, vertical = 15.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = {
                                onClickSave(isCreateMode)
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    NonScaleText(
                        text = "Save",
                        color = when (isCreateMode) {
                            true -> Purple4
                            false -> Blue4
                        },
                        fontSize = 15.sp,
                        fontWeight = FontWeight(600)
                    )
                }
            }
        }
    }
}

private fun changeMonthFormat(month: String): String = kotlin.runCatching {
    return@runCatching when (month.toInt()) {
        1 -> "January"
        2 -> "February"
        3 -> "March"
        4 -> "April"
        5 -> "May"
        6 -> "June"
        7 -> "July"
        8 -> "August"
        9 -> "September"
        10 -> "October"
        11 -> "November"
        12 -> "December"
        else -> throw IllegalArgumentException()
    }
}.getOrDefault("January")

//@Preview(showBackground = true)
@Composable
fun EditTaskDialogScreenPreview() {
    val dateString = "2023-09-20T08:59:00"

    val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
    val dateTime = LocalDateTime.parse(dateString, dateTimeFormatter)

    TaskDialogScreen(
        taskState = TaskState(
            taskId = -1L,
            deadLine = dateTime,
            courseName = "test course name",
            taskName = "test task name",
        ),
    )
}

//@Preview(showBackground = true)
@Composable
fun CreateTaskDialogScreenPreview() {
    val dateString = "2023-09-20T08:59:00"

    val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
    val dateTime = LocalDateTime.parse(dateString, dateTimeFormatter)

    TaskDialogScreen(
        taskState = TaskState(
            taskId = -1L,
            deadLine = dateTime,
            courseName = "test course name",
            taskName = "test task name",
        ),
        isCreateMode = true
    )
}