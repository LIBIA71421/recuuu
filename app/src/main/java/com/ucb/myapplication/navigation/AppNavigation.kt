package com.ucb.myapplication.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ucb.myapplication.reminder.ReminderFormUI
import com.ucb.myapplication.reminder.ReminderListUI
import com.ucb.myapplication.splash.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,

        ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(
                onFinished = {
                    navController.navigate(Screen.ReminderListScreen.route) {
                        popUpTo(Screen.SplashScreen.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.ReminderListScreen.route) {
            ReminderListUI(
                onAdd = {
                    navController.navigate(Screen.ReminderFormScreen.route)
                }
            )
        }

        composable(Screen.ReminderFormScreen.route) {
            ReminderFormUI(
                onSaved = {
                    navController.popBackStack()
                }
            )
        }
    }
}