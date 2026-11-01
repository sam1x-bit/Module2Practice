package ru.mosit.module2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Задание 6. Векторный круг из res/drawable/circle.xml

// Круг исходного размера в правом верхнем углу чёрного компонента 240x120
@Composable
fun CircleTopEnd(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Black),
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Круг"
        )
    }
}

// Синий фон, круг по центру растянут по размерам, перекрашен в фиолетовый
@Composable
fun StretchedPurpleCircle(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Blue)
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Фиолетовый круг",
            modifier = Modifier.fillMaxSize(),
            alignment = Alignment.Center,
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(Color(0xFF800080))
        )
    }
}

@Composable
fun Task6Screen(modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        CircleTopEnd()
        StretchedPurpleCircle()
    }
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun CircleTopEndPreview() {
    CircleTopEnd()
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun StretchedPurpleCirclePreview() {
    StretchedPurpleCircle()
}
