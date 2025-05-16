package com.ucb.framework.reminder

import android.content.Context
import com.ucb.data.reminder.IReminderLocalDataSource
import com.ucb.domain.Reminder
import com.ucb.framework.persistance.AppRoomDatabase

class ReminderLocalDataSource(context: Context) : IReminderLocalDataSource {

    private val dao = AppRoomDatabase.getDatabase(context).reminderDao()

    override suspend fun saveReminder(reminder: Reminder): Boolean {
        dao.insert(reminder.toEntity())
        return true
    }

    override suspend fun getAllReminders(): List<Reminder> {
        return dao.getAll().map { it.toModel() }
    }
}
