package ru.mosit.module2

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

// Задание 10. Исправленная корзина интернет-магазина
//
// Ошибки исходного кода:
// 1. totalSum и productSize были полями Activity и увеличивались прямо в теле
//    composable-функции. При каждой рекомпозиции (добавление/удаление товара,
//    поворот экрана) к старой сумме заново прибавлялись цены всех товаров —
//    сумма росла, и с покупателя требовали больше денег.
// 2. AddProductSection и RemoveProductSection читали эти поля неявно (не через
//    параметры), поэтому не были идемпотентными: они не получали актуальных
//    данных и не перерисовывались, когда это было нужно.
// 3. productSize никогда не уменьшался — кнопка «Удалить товар» не скрывалась
//    при пустой корзине.
// 4. Toast вызывался прямо в композиции и показывался при каждой рекомпозиции.
// 5. Корзина хранилась в remember и терялась при повороте экрана.
// 6. id нового товара = products.size — после удаления id могли повторяться.
//
// Исправление: сумма и признак непустой корзины вычисляются из состояния и
// передаются явными параметрами; Toast — побочный эффект в LaunchedEffect;
// корзина хранится в rememberSaveable.

data class Cart(
    val products: List<Product>
)

data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

// Сохранение списка товаров в Bundle (для rememberSaveable)
private val ProductListSaver = listSaver<List<Product>, Any>(
    save = { list -> list.flatMap { listOf(it.id, it.name, it.price) } },
    restore = { flat ->
        flat.chunked(3).map { (id, name, price) -> Product(id as Int, name as String, price as Int) }
    }
)

const val FREE_DELIVERY_SUM = 500

@Composable
fun ShoppingCartScreen(modifier: Modifier = Modifier) {
    var products by rememberSaveable(stateSaver = ProductListSaver) {
        mutableStateOf(
            listOf(
                Product(0, "Товар #1", 100),
                Product(1, "Товар #2", 150),
                Product(2, "Товар #3", 56)
            )
        )
    }
    val cart = Cart(products)
    // Сумма считается заново из состояния, а не накапливается
    val totalSum = cart.products.sumOf { it.price }

    Column(modifier = modifier) {
        for (product in cart.products) {
            Text(text = product.name + " - " + product.price + " рублей")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Товаров на сумму: $totalSum рублей")
        AddProductSection(totalSum = totalSum) {
            val nextId = (products.maxOfOrNull { it.id } ?: -1) + 1
            products = products + Product(
                id = nextId,
                name = "Товар #${products.size + 1}",
                price = Random.nextInt(0, 100)
            )
        }
        RemoveProductSection(hasProducts = cart.products.isNotEmpty()) {
            products = products.dropLast(1)
        }
    }
}

@Composable
fun AddProductSection(
    totalSum: Int,
    onAdd: () -> Unit
) {
    val context = LocalContext.current
    val freeDelivery = totalSum > FREE_DELIVERY_SUM
    var freeDeliveryShown by rememberSaveable { mutableStateOf(false) }
    // Если сумма заказа больше 500, один раз показываем сообщение о бесплатной доставке
    LaunchedEffect(freeDelivery) {
        if (freeDelivery && !freeDeliveryShown) {
            Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
        }
        freeDeliveryShown = freeDelivery
    }
    Button(onClick = onAdd) {
        Text(text = "Добавить товар")
    }
}

@Composable
fun RemoveProductSection(
    hasProducts: Boolean,
    onRemove: () -> Unit
) {
    if (hasProducts) {
        Button(onClick = onRemove) {
            Text(text = "Удалить товар")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingCartScreenPreview() {
    ShoppingCartScreen()
}
