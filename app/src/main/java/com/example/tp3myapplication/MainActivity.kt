package com.example.tp3myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.tp3myapplication.ui.navigation.AppNavigation
import com.example.tp3myapplication.ui.theme.TP3MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // La app se dibuja de borde a borde, con íconos oscuros en las barras
        // del sistema (hora, batería) para que se vean sobre el fondo blanco
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT)
        )

        setContent {
            TP3MyApplicationTheme {
                AppNavigation()
            }
        }
    }
}