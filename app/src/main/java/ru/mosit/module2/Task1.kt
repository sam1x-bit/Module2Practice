package ru.mosit.module2

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

// Задание 1. Приветствие по имени; при null — «Имя не задано»
@Composable
fun Hello(name: String?, modifier: Modifier = Modifier) {
    Text(
        text = if (name != null) "Привет, $name!" else "Имя не задано",
        fontSize = 24.sp,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun HelloNamePreview() {
    Hello(name = "Николай")
}

@Preview(showBackground = true)
@Composable
fun HelloNullPreview() {
    Hello(name = null)
}
