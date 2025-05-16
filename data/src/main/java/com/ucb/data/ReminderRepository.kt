package com.ucb.data

import com.ucb.data.reminder.IReminderLocalDataSource
import com.ucb.domain.Reminder

class ReminderRepository(
    private val localDataSource: IReminderLocalDataSource
) {
    suspend fun save(reminder: Reminder): Boolean = localDataSource.saveReminder(reminder)
    suspend fun getAll(): List<Reminder> = localDataSource.getAllReminders()
}