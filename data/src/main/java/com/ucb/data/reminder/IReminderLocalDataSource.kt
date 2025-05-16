package com.ucb.data.reminder

import com.ucb.domain.Reminder

interface IReminderLocalDataSource {
    suspend fun saveReminder(reminder: Reminder): Boolean
    suspend fun getAllReminders(): List<Reminder>
}