package ru.mosit.module2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Задание 5. Серый контейнер 100.dp, посередине круг с инициалами
@Composable
fun InitialsHeader(initials: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxHeight() // круг занимает всю доступную высоту
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(Color(0xFFFF5722)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = initials, color = Color.Black)
        }
    }
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun Task5Preview() {
    InitialsHeader(initials = "НП")
}
