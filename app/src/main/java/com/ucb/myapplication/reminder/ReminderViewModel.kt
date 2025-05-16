package com.ucb.myapplication.reminder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.domain.Reminder
import com.ucb.usecases.GetAllReminders
import com.ucb.usecases.SaveReminder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReminderViewModel @Inject constructor(
    private val saveReminder: SaveReminder,
    private val getAllReminders: GetAllReminders
) : ViewModel() {

    private val _reminders = MutableStateFlow<List<Reminder>>(emptyList())
    val reminders: StateFlow<List<Reminder>> = _reminders

    fun addReminder(reminder: Reminder) {
        viewModelScope.launch {
            saveReminder.invoke(reminder)
            loadReminders()
        }
    }

    fun loadReminders() {
        viewModelScope.launch {
            _reminders.value = getAllReminders.invoke()
        }
    }
}
