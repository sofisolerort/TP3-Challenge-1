package com.example.tp3myapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.sp
import com.example.tp3myapplication.R

// Familia Poppins: une los 3 archivos de res/font en una sola fuente con sus pesos
val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),     // 400
    Font(R.font.poppins_medium, FontWeight.Medium),      // 500
    Font(R.font.poppins_semibold, FontWeight.SemiBold)   // 600
)

// Estilos de texto del Figma
val Typography = Typography(

    // "Discover Your Dream Job here"
    headlineLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = 35.sp,
        lineHeight = 53.sp
    ),

    // "Login here" / "Create Account"
    headlineMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = 30.sp,
        lineHeight = 45.sp
    ),

    // Subtítulo del Login, texto de botones, "Register"
    titleLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 30.sp
    ),

    // Links: "Forgot your password?", "Create new account", "Or continue with"
    titleSmall = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 21.sp
    ),

    // Texto dentro de los inputs (Email, Password)
    bodyLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),

    // Subtítulo del Welcome
    bodyMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 21.sp
    ),

    // Subtítulo del Register
    bodySmall = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 21.sp
    )
)