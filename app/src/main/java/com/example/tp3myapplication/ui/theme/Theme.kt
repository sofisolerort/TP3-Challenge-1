package com.example.tp3myapplication.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Paleta que usan por defecto los componentes de Material 3
private val AppColorScheme = lightColorScheme(
    primary = BluePrimary,          // botones, cursor, bordes activos
    onPrimary = Color.White,        // texto sobre el azul
    background = Color.White,       // fondo de las pantallas
    onBackground = Color.Black,     // texto sobre el fondo
    surface = Color.White,
    onSurface = Color.Black
)

@Composable
fun TP3MyApplicationTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        typography = Typography,
        content = content
    )
}