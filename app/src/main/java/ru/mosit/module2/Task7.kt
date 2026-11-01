package ru.mosit.module2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Задание 7. Карточки контактов на Column и Row

data class Contact(
    val name: String,
    val patronymic: String,
    val surname: String,
    val phone: String?,
    val address: String
)

val sampleContacts = listOf(
    Contact("Евгений", "Андреевич", "Лукашин", "+7 495 495 95 95", "г. Москва, 3-я улица Строителей, д. 25, кв. 12"),
    Contact("Василий", "Егорович", "Кузякин", null, "Ивановская область, дер. Крутово, д. 4"),
    Contact("Людмила", "Прокофьевна", "Калугина", "+7 495 788 78 78", "Москва, Большая Никитская, д. 43, кв. 290")
)

private val CardColor = Color(0xFFCCCCCC)

// Поля контакта столбиком
@Composable
fun ContactColumn(
    contact: Contact,
    modifier: Modifier = Modifier,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start
) {
    Column(modifier = modifier, horizontalAlignment = horizontalAlignment) {
        Text(text = "Имя: ${contact.name}")
        Text(text = "Отчество: ${contact.patronymic}")
        Text(text = "Фамилия: ${contact.surname}")
        Text(text = "Мобильный телефон: ${contact.phone ?: "---"}")
        Text(text = "Адрес: ${contact.address}")
    }
}

// Список карточек контактов на сером фоне
@Composable
fun ContactList(contacts: List<Contact>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        for (contact in contacts) {
            ContactColumn(
                contact = contact,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(CardColor)
                    .padding(8.dp)
            )
        }
    }
}

// Карточка контакта с изображением справа
@Composable
fun ContactRow(contact: Contact, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(CardColor)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ContactColumn(
            contact = contact,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        )
        Image(
            painter = painterResource(R.drawable.star),
            contentDescription = "Избранное",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun Task7Screen(modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        ContactColumn(sampleContacts[0])
        ContactList(sampleContacts)
        ContactRow(sampleContacts[0])
    }
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun ContactColumnPreview() {
    ContactColumn(sampleContacts[0])
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun ListPreview() {
    ContactList(sampleContacts)
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun ContactRowPreview() {
    ContactRow(sampleContacts[0])
}
