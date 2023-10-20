package com.ajouunia.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ajouunia.core.designsystem.Purple4
import com.ajouunia.core.designsystem.UniAIconPack
import com.ajouunia.core.designsystem.uniaiconpack.IcSelectedCircle
import com.ajouunia.core.designsystem.uniaiconpack.IcUnselectedCircle

@Composable
fun UniASelectDialog(
    modifier: Modifier = Modifier,
    title: String,
    list: List<String> = emptyList(),
    onClickConfirm: (String) -> Unit = {},
    onClickCancel: () -> Unit = {}
) {
    val context = LocalContext.current
    var selectedItem by remember {
        mutableIntStateOf(0)
    }

    Dialog(onDismissRequest = {}) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(color = Color.White, shape = RoundedCornerShape(16.dp))
                .padding(
                    top = 25.dp,
                    start = 25.dp,
                    end = 20.dp
                ),
        ) {
            NonScaleText(
                text = title,
                fontSize = 18.sp,
                lineHeight = 13.sp,
                fontWeight = FontWeight(700),
                color = Color.Black,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(25.dp))

            LazyColumn(
                modifier = Modifier.heightIn(max = 325.dp)
            ) {
                items(list.size) { index ->
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                imageVector = when (selectedItem) {
                                    index -> UniAIconPack.IcSelectedCircle
                                    else -> UniAIconPack.IcUnselectedCircle
                                },
                                contentDescription = null,
                                modifier = Modifier.clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null,
                                    onClick = {
                                        selectedItem = index
                                    }
                                )
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            NonScaleText(
                                text = list[index],
                                color = Color.Black,
                                fontSize = 13.sp,
                                fontWeight = FontWeight(500),
                                lineHeight = 13.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(Color.White),
                    onClick = {
                        onClickCancel()
                    },
                ) {
                    NonScaleText(
                        text = "Cancel",
                        fontSize = 15.sp,
                        lineHeight = 10.sp,
                        fontWeight = FontWeight(600),
                        color = Purple4,
                        textAlign = TextAlign.Center,
                    )
                }
                Button(
                    colors = ButtonDefaults.buttonColors(Color.White),
                    onClick = {
                        onClickConfirm(list[selectedItem])
                    },
                ) {
                    NonScaleText(
                        text = "OK",
                        fontSize = 15.sp,
                        lineHeight = 10.sp,
                        fontWeight = FontWeight(600),
                        color = Purple4,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UniASelectDialogPreview() {
    UniASelectDialog(
        title = "Select department",
        list = listOf(
            "Mechanical Engineering",
            "Industrial Engineering",
            "Chemical Engineering",
            "Materials Science and Engineering",
            "Applied Chemistry and Biological Engr.",
            "Environmental Engineering",
            "Civil System Engineering",
            "Transportation System Engineering",
            "Architecture",
            "Electrical and Computer Engineering",
            "Cyber Security"
        )
    )
}