package com.ucb.framework.persistance

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reminders")
data class ReminderEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val date: String,
    val importance: String // NORMAL, IMPORTANT, VERY_IMPORTANT
)