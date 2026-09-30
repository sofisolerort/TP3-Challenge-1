package com.example.tp3myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tp3myapplication.ui.screens.LoginScreen
import com.example.tp3myapplication.ui.screens.RegisterScreen
import com.example.tp3myapplication.ui.screens.WelcomeScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    // Controla a qué pantalla ir y guarda el historial (la pila)
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route,   // primera pantalla que se ve
        modifier = modifier
    ) {
        // Welcome
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                onLoginClick = { navController.navigate(Screen.Login.route) },
                onRegisterClick = { navController.navigate(Screen.Register.route) }
            )
        }

        // Login
        composable(Screen.Login.route) {
            LoginScreen(
                onSignInClick = { /* sin back: por ahora no hace nada */ },
                onCreateAccountClick = {
                    navController.navigate(Screen.Register.route) {
                        popUpTo(Screen.Welcome.route)   // no apila pantallas de más
                        launchSingleTop = true
                    }
                }
            )
        }

        // Register
        composable(Screen.Register.route) {
            RegisterScreen(
                onSignUpClick = { /* sin back: por ahora no hace nada */ },
                onHaveAccountClick = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Welcome.route)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}