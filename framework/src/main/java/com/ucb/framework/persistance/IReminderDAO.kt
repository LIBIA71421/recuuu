package com.ucb.framework.persistance

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IReminderDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(reminder: ReminderEntity)

    @Query("SELECT * FROM reminders")
    suspend fun getAll(): List<ReminderEntity>
}
