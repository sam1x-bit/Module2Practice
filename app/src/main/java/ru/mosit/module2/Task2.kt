package ru.mosit.module2

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

// Задание 2. Три макета предпросмотра функции Hello с системным UI

@Preview(
    name = "portrait",
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp,orientation=portrait"
)
@Preview(
    name = "landscape",
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp,orientation=landscape"
)
@Preview(
    name = "round",
    showSystemUi = true,
    showBackground = true,
    backgroundColor = 0xFFFFFF00, // жёлтый фон
    device = "spec:width=200dp,height=200dp,dpi=320,isRound=true"
)
@Composable
fun HelloPreview() {
    Hello(name = "Николай")
}
