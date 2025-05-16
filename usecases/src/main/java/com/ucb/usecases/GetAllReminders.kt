package com.ucb.usecases

import com.ucb.data.ReminderRepository
import com.ucb.domain.Reminder

class GetAllReminders(
    private val repository: ReminderRepository
) {
    suspend fun invoke(): List<Reminder> = repository.getAll()
}