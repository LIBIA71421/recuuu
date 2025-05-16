package com.ucb.usecases

import com.ucb.data.ReminderRepository
import com.ucb.domain.Reminder

class SaveReminder(
    private val repository: ReminderRepository
) {
    suspend fun invoke(reminder: Reminder): Boolean = repository.save(reminder)
}
