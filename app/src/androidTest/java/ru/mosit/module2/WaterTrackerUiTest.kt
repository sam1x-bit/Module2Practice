package ru.mosit.module2

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import ru.mosit.module2.ui.theme.Module2PracticeTheme

// Задание 9. UI-тесты трекера воды из задания 8
class WaterTrackerUiTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            Module2PracticeTheme {
                WaterTracker()
            }
        }
    }

    private fun addWater(times: Int) {
        repeat(times) { composeTestRule.onNodeWithText("+250 мл").performClick() }
    }

    private fun finishDay() {
        composeTestRule.onNodeWithText("Завершить день").performClick()
    }

    private fun streakText(days: Int) = "Дней подряд от 1500 мл: $days"

    // 1) Кнопка добавления жидкости есть и увеличивает счётчик на 250 мл
    @Test
    fun addButton_existsAndAdds250() {
        composeTestRule.onNodeWithText("+250 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()

        addWater(1)
        composeTestRule.onNodeWithText("250 мл").assertIsDisplayed()

        addWater(2)
        composeTestRule.onNodeWithText("750 мл").assertIsDisplayed()
    }

    // 2) Кнопка «Завершить день» есть и сбрасывает счётчик воды до нуля
    @Test
    fun finishDayButton_existsAndResetsWater() {
        composeTestRule.onNodeWithText("Завершить день").assertIsDisplayed()

        addWater(3)
        composeTestRule.onNodeWithText("750 мл").assertIsDisplayed()

        finishDay()
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
    }

    // 3) Выводится текст с количеством дней подряд, когда выпито 1500 мл и больше
    @Test
    fun streakText_isShownAndCountsDays() {
        composeTestRule.onNodeWithText(streakText(0)).assertIsDisplayed()

        // День с нормой (6 × 250 = 1500 мл) — счётчик дней растёт
        addWater(6)
        finishDay()
        composeTestRule.onNodeWithText(streakText(1)).assertIsDisplayed()

        addWater(7)
        finishDay()
        composeTestRule.onNodeWithText(streakText(2)).assertIsDisplayed()

        // День без нормы (1250 мл) — счётчик дней обнуляется
        addWater(5)
        finishDay()
        composeTestRule.onNodeWithText(streakText(0)).assertIsDisplayed()
    }
}
