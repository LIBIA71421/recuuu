package com.ucb.myapplication.reminder

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ucb.domain.ImportanceLevel
import com.ucb.domain.Reminder

@Composable
fun ReminderFormUI(
    viewModel: ReminderViewModel = hiltViewModel(),
    onSaved: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var importance by remember { mutableStateOf(ImportanceLevel.NORMAL) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Fecha (yyyy-MM-dd)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        DropdownMenuImportance(selected = importance, onSelect = { importance = it })

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.addReminder(Reminder(name, date, importance))
            onSaved()
        }) {
            Text("Guardar")
        }
    }
}

@Composable
fun DropdownMenuImportance(
    selected: ImportanceLevel,
    onSelect: (ImportanceLevel) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedButton(onClick = { expanded = true }) {
            Text("Importancia: ${selected.name}")
        }

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            ImportanceLevel.values().forEach {
                DropdownMenuItem(
                    text = { Text(it.name) },
                    onClick = {
                        onSelect(it)
                        expanded = false
                    }
                )
            }
        }
    }
}
