package com.example.tp3myapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp3myapplication.R
import com.example.tp3myapplication.ui.components.DecorativeBackground
import com.example.tp3myapplication.ui.components.PrimaryButton
import com.example.tp3myapplication.ui.theme.BluePrimary
import com.example.tp3myapplication.ui.theme.TP3MyApplicationTheme

@Composable
fun WelcomeScreen(
    onLoginClick: () -> Unit,       // qué hacer al tocar "Login"
    onRegisterClick: () -> Unit,    // qué hacer al tocar "Register"
    modifier: Modifier = Modifier
) {
    // Box apila capas: primero el fondo, encima el contenido
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        DecorativeBackground()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()               // no se mete abajo de la barra de estado
                .padding(horizontal = 31.dp),      // Figma: márgenes laterales
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Ilustración
            Image(
                painter = painterResource(R.drawable.welcome_image),
                contentDescription = null,         // es decorativa, el lector de pantalla la saltea
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.weight(0.8f))

            // "Discover Your Dream Job here"
            Text(
                text = stringResource(R.string.welcome_title),
                style = MaterialTheme.typography.headlineLarge,
                color = BluePrimary,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(23.dp))

            // "Explore all the existing job roles..."
            Text(
                text = stringResource(R.string.welcome_subtitle),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.weight(1.1f))

            // Botones "Login" y "Register"
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),   // Figma: los botones tienen 39 de margen (31 + 8)
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                PrimaryButton(
                    text = stringResource(R.string.welcome_login),
                    onClick = onLoginClick,
                    modifier = Modifier.weight(1f)
                )

                TextButton(
                    onClick = onRegisterClick,
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.textButtonColors(contentColor = Color.Black)
                ) {
                    Text(
                        text = stringResource(R.string.welcome_register),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Spacer(modifier = Modifier.weight(0.6f))
        }
    }
}

@Preview(showBackground = true, widthDp = 428, heightDp = 926)
@Composable
private fun WelcomeScreenPreview() {
    TP3MyApplicationTheme {
        WelcomeScreen(
            onLoginClick = {},
            onRegisterClick = {}
        )
    }
}