package com.ucb.myapplication.reminder

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ucb.domain.Reminder

@Composable
fun ReminderListUI(
    viewModel: ReminderViewModel = hiltViewModel(),
    onAdd: () -> Unit
) {
    val reminders by viewModel.reminders.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadReminders()
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAdd) {
                Text("+")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            LazyColumn {
                items(reminders.size) { i ->
                    ReminderCard(reminders[i])
                }
            }
        }
    }
}

@Composable
fun ReminderCard(reminder: Reminder) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Nombre: ${reminder.name}")
            Text("Fecha: ${reminder.date}")
            Text("Importancia: ${reminder.importance}")
        }
    }
}
