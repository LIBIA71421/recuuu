package com.ucb.myapplication.navigation

sealed class Screen(val route: String) {
    object ReminderListScreen : Screen("reminder_list")
    object ReminderFormScreen : Screen("reminder_form")
    object SplashScreen : Screen("splash")
}
