package com.ucb.myapplication.di

import android.content.Context
import com.ucb.data.ReminderRepository
import com.ucb.data.reminder.IReminderLocalDataSource
import com.ucb.framework.persistance.AppRoomDatabase
import com.ucb.framework.persistance.IReminderDAO
import com.ucb.framework.reminder.ReminderLocalDataSource
import com.ucb.usecases.GetAllReminders
import com.ucb.usecases.SaveReminder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppRoomDatabase(@ApplicationContext context: Context): AppRoomDatabase {
        return AppRoomDatabase.getDatabase(context)
    }

    //@Provides
    //@Singleton
    //fun provideReminderDao(db: AppRoomDatabase): IReminderDAO {
    //    return db.reminderDao()
    //}
    //fun provideReminderDao(db: AppRoomDatabase) = db.reminderDao()

    @Provides
    @Singleton
    fun provideReminderLocalDataSource(@ApplicationContext context: Context): IReminderLocalDataSource {
        return ReminderLocalDataSource(context)
    }

    @Provides
    @Singleton
    fun provideReminderRepository(localDataSource: IReminderLocalDataSource): ReminderRepository {
        return ReminderRepository(localDataSource)
    }

    @Provides
    @Singleton
    fun provideSaveReminder(repository: ReminderRepository): SaveReminder {
        return SaveReminder(repository)
    }

    @Provides
    @Singleton
    fun provideGetAllReminders(repository: ReminderRepository): GetAllReminders {
        return GetAllReminders(repository)
    }
}
