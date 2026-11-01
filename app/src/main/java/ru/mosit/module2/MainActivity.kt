package ru.mosit.module2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.mosit.module2.ui.theme.Module2PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module2PracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// Номера заданий, у которых есть экран в приложении
private val tasks = listOf(1, 3, 4, 5, 6, 7, 8, 10)

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var selectedTask by rememberSaveable { mutableIntStateOf(0) }

    if (selectedTask == 0) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (task in tasks) {
                Button(onClick = { selectedTask = task }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Задание $task")
                }
            }
        }
    } else {
        BackHandler { selectedTask = 0 }
        val taskModifier = modifier.padding(16.dp)
        when (selectedTask) {
            // Задание 1: вызов Hello в активити (второй вариант запуска — Hello(name = null))
            1 -> Hello(name = "Николай", modifier = taskModifier)
            3 -> Task3Screen(taskModifier)
            4 -> WideButton(taskModifier)
            5 -> InitialsHeader(initials = "НП", modifier = modifier)
            6 -> Task6Screen(taskModifier)
            7 -> Task7Screen(modifier.verticalScroll(rememberScrollState()))
            8 -> WaterTracker(modifier)
            10 -> ShoppingCartScreen(taskModifier)
        }
    }
}
