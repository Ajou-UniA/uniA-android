package com.ajouunia.feature.task.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajouunia.core.designsystem.UniAIconPack
import com.ajouunia.core.designsystem.component.NonScaleText
import com.ajouunia.core.designsystem.uniaiconpack.IcMoreSee
import com.ajouunia.core.domain.entity.TaskEntity
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.util.Locale

private val dayFormat = DateTimeFormatter.ofPattern("dd")
private val monthFormat = DateTimeFormatter.ofPattern("MM")
private val timeFormat = DateTimeFormatter.ofPattern("hh:mm a").withLocale(Locale.US)

@Composable
fun TaskInfoScreen(
    modifier: Modifier = Modifier,
    entity: TaskEntity
) = Column {
    Divider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 1.dp,
        color = Color(0xFFE3E3E3)
    )
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .width(64.dp)
                .height(64.dp)
                .background(
                    color = Color(0xFFBB8EFF),
                    shape = RoundedCornerShape(size = 16.dp)
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NonScaleText(
                text = dayFormat.format(entity.deadLine),
                color = Color.Black,
                fontSize = 23.sp,
                fontWeight = FontWeight(600),
            )
            NonScaleText(
                text = (monthFormat.format(entity.deadLine).toLongOrNull() ?: 1L).parseMonth(),
                color = Color.Black,
                fontSize = 10.sp,
                fontWeight = FontWeight(600),
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .background(Color.White)
                .padding(start = 15.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent),
                verticalAlignment = Alignment.CenterVertically
            ) {
                NonScaleText(
                    text = entity.courseName,
                    color = Color(0xFF8A8A8A),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(600),
                    lineHeight = 9.sp,
                    modifier = Modifier.weight(1f),
                    maxLines = 1
                )
                Image(
                    imageVector = UniAIconPack.IcMoreSee,
                    contentDescription = null
                )
            }
            NonScaleText(
                text = entity.taskName,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                lineHeight = 12.sp,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent),
                horizontalArrangement = Arrangement.End
            ) {
                NonScaleText(
                    text = "by ${timeFormat.format(entity.deadLine)}",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(600),
                    lineHeight = 9.sp,
                )
            }
        }
    }
}

private fun Long.parseMonth(): String = when (this) {
    2L -> "Feb."
    3L -> "Mar."
    4L -> "Apr."
    5L -> "May."
    6L -> "Jun."
    7L -> "Jul."
    8L -> "Aug."
    9L -> "Sept."
    10L -> "Oct."
    11L -> "Nov."
    12L -> "Dec."
    else -> "Jan."
}

@Preview(showBackground = true)
@Composable
fun TaskInfoScreenPreview() {
    val dateString = "2023-10-20T10:00:00"

    val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
    val dateTime = LocalDateTime.parse(dateString, dateTimeFormatter)

    TaskInfoScreen(
        entity = TaskEntity(
            taskId = 1L,
            deadLine = dateTime,
            courseName = "course name",
            taskName = "Task name"
        )
    )
}