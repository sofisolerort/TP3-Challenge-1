package com.example.tp3myapplication.ui.navigation

// Todas las pantallas de la app, cada una con su ruta
sealed class Screen(val route: String) {
    data object Welcome : Screen("welcome")
    data object Login : Screen("login")
    data object Register : Screen("register")
}