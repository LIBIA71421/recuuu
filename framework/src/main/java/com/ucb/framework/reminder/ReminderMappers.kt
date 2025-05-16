package com.ucb.framework.reminder

import com.ucb.domain.ImportanceLevel
import com.ucb.domain.Reminder
import com.ucb.framework.persistance.ReminderEntity

fun Reminder.toEntity(): ReminderEntity {
    return ReminderEntity(
        name = this.name,
        date = this.date,
        importance = this.importance.name
    )
}

fun ReminderEntity.toModel(): Reminder {
    return Reminder(
        name = this.name,
        date = this.date,
        importance = ImportanceLevel.valueOf(this.importance)
    )
}