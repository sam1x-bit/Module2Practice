# Модуль 2 — Практические задания 1–10 (Jetpack Compose)

Android-приложение на Kotlin и Jetpack Compose с решениями практических заданий 1–10 модуля 2.
Автор: Прокофьев Н. Ю., группа ИКБО-62-24.

| Задание | Файл | Содержание |
|---|---|---|
| 1 | `Task1.kt` | `Hello(name: String?)`, при `null` — «Имя не задано» |
| 2 | `Task2.kt` | Превью `portrait`, `landscape`, `round` (200×200 dp, жёлтый фон) |
| 3 | `Task3.kt`, `res/values/strings.xml` | Текст из ресурсов в трёх вариантах оформления |
| 4 | `Task4.kt` | Кнопка во всю ширину, скругление 16 dp, рамка, тень |
| 5 | `Task5.kt` | Серый контейнер 100 dp с кругом-инициалами |
| 6 | `Task6.kt`, `res/drawable/circle.xml` | Векторный круг: в углу чёрного блока и растянутый фиолетовый |
| 7 | `Task7.kt` | Карточки контактов на `Column` и `Row` |
| 8 | `Task8.kt` | Трекер воды: +250 мл, «Завершить день», серия дней от 1500 мл |
| 9 | `androidTest/.../WaterTrackerUiTest.kt` | UI-тесты трекера воды |
| 10 | `Task10.kt` | Исправленная корзина интернет-магазина |

Исходники: `app/src/main/java/ru/mosit/module2/`. Скриншоты — в папке `screenshots/`.

Сборка: `./gradlew assembleDebug`; UI-тесты (нужен эмулятор или устройство): `./gradlew connectedDebugAndroidTest`.
