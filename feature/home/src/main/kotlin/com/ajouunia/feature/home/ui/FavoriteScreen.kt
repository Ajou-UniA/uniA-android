package com.ajouunia.feature.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajouunia.core.designsystem.component.NonScaleText
import com.ajouunia.core.domain.entity.FavoriteEntity

@Composable
internal fun FavoriteScreen(
    modifier: Modifier = Modifier,
    entity: FavoriteEntity,
    onClick: (FavoriteEntity) -> Unit = {}
) = Column(
    modifier = modifier
        .background(Color.White)
        .padding(4.dp),
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Box(
        modifier = Modifier
            .width(70.dp)
            .height(70.dp)
            .background(
                color = Color(0xFFF5F5F5),
                shape = RoundedCornerShape(size = 15.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        NonScaleText(
            text = entity.acronyms,
            color = entity.color,
            fontSize = 33.sp,
            fontWeight = FontWeight(600)
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
    NonScaleText(
        text = entity.title,
        color = Color.Black,
        fontSize = 10.sp,
        fontWeight = FontWeight(600)
    )
}

@Preview(showBackground = true)
@Composable
private fun FavoriteScreenPreview() {
    Column {
        FavoriteScreen(
            entity = FavoriteEntity(
                title = "Ajou Notice",
                acronyms = "AN",
                link = "https://www.ajou.ac.kr/kr/ajou/notice.do",
                color = Color(0xFF6DA8FF)
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        FavoriteScreen(
            entity = FavoriteEntity(
                title = "Ajou Portal",
                acronyms = "AP",
                link = "https://mportal.ajou.ac.kr/main.do",
                color = Color(0xFF90DCFF)
            ),
        )
        Spacer(modifier = Modifier.height(4.dp))
        FavoriteScreen(
            entity =  FavoriteEntity(
                title = "OIA",
                acronyms = "OIA",
                link = "",
                color = Color(0xFFC3C7FF)
            ),
        )
        Spacer(modifier = Modifier.height(4.dp))
        FavoriteScreen(
            entity = FavoriteEntity(
                title = "Central Library",
                acronyms = "CL",
                link = "https://mportal.ajou.ac.kr/main.do",
                color = Color(0xFFDCC6FF),
            ),
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}