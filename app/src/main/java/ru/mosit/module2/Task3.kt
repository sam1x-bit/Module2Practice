package ru.mosit.module2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Задание 3. Текст из ресурсов в нескольких вариантах оформления

// Вариант 1: зелёный, 16.sp, курсив, по центру
@Composable
fun GreenItalicText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.jetpack_compose_description),
        color = Color.Green,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

// Вариант 2: одна строка, в конце многоточие
@Composable
fun SingleLineText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.jetpack_compose_description),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier
    )
}

// Вариант 3: отступ первой строки 48.sp, 24.sp, чёрный текст, зелёный фон, подчёркивание
@Composable
fun IndentedUnderlinedText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.jetpack_compose_description),
        fontSize = 24.sp,
        color = Color.Black,
        textDecoration = TextDecoration.Underline,
        style = TextStyle(textIndent = TextIndent(firstLine = 48.sp)),
        modifier = modifier.background(Color.Green)
    )
}

@Composable
fun Task3Screen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        GreenItalicText(Modifier.fillMaxWidth())
        SingleLineText()
        IndentedUnderlinedText()
    }
}

@Preview(showBackground = true)
@Composable
fun GreenItalicTextPreview() {
    GreenItalicText()
}

@Preview(showBackground = true)
@Composable
fun SingleLineTextPreview() {
    SingleLineText()
}

@Preview(showBackground = true)
@Composable
fun IndentedUnderlinedTextPreview() {
    IndentedUnderlinedText()
}
