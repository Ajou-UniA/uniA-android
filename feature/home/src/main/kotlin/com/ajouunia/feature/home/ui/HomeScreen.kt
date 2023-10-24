package com.ajouunia.feature.home.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajouunia.core.designsystem.component.NonScaleText
import com.ajouunia.core.domain.entity.FavoriteEntity
import com.ajouunia.feature.home.state.HomeUIState

private val favoriteList: List<FavoriteEntity> by lazy {
    listOf(
        FavoriteEntity(
            title = "Ajou Notice",
            acronyms = "AN",
            link = "https://www.ajou.ac.kr/kr/ajou/notice.do",
            color = Color(0xFF6DA8FF)
        ),
        FavoriteEntity(
            title = "Ajou Portal",
            acronyms = "AP",
            link = "https://mportal.ajou.ac.kr/main.do",
            color = Color(0xFF90DCFF)
        ),
        FavoriteEntity(
            title = "OIA",
            acronyms = "OIA",
            link = "",
            color = Color(0xFFC3C7FF)
        ),
        FavoriteEntity(
            title = "Central Library",
            acronyms = "CL",
            link = "https://mportal.ajou.ac.kr/main.do",
            color = Color(0xFFDCC6FF),
        ),
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeUIState,
    onClickMap: () -> Unit = {}
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),
    ) {
        item {
            NonScaleText(
                text = "Hello UniA",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight(700)
            )
            Spacer(modifier = Modifier.height(35.dp))
            when (uiState.taskList.isEmpty()) {
                true -> Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(210.dp),
                    painter = painterResource(id = com.ajouunia.core.designsystem.R.drawable.image_home_empty_task),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                false -> {

                }
            }
            Spacer(modifier = Modifier.height(35.dp))
        }

        item {
            NonScaleText(
                text = "Favorite",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight(600)
            )
            Spacer(modifier = Modifier.height(20.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(favoriteList.size) { index ->
                    FavoriteScreen(
                        entity = favoriteList[index],
                        onClick = {

                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(55.dp))
        }

        item {
            NonScaleText(
                text = "Ajou Campus Map",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight(600)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = onClickMap
                    ),
                painter = painterResource(id = com.ajouunia.core.designsystem.R.drawable.ic_ajou_univ_map),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
        }

        item {
            Spacer(modifier = Modifier.height(34.dp))
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(uiState.partitions.size) { listIndex ->
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        (uiState.partitions[listIndex].indices).forEach { index ->
                            GuideItemScreen(item = uiState.partitions[listIndex][index])
                        }
                    }
                    Spacer(modifier = Modifier.width(30.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(uiState = HomeUIState.Init)
}