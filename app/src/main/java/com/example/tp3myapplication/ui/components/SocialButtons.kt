package com.example.tp3myapplication.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp3myapplication.R
import com.example.tp3myapplication.ui.theme.SocialButtonGray
import com.example.tp3myapplication.ui.theme.TP3MyApplicationTheme

// Un botón gris con un ícono adentro
@Composable
fun SocialButton(
    @DrawableRes iconRes: Int,          // el ícono de res/drawable
    contentDescription: String,         // lo que lee el lector de pantalla
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(width = 60.dp, height = 44.dp)   // Figma: 60 x 44
            .clip(RoundedCornerShape(10.dp))       // Figma: bordes de 10
            .background(SocialButtonGray)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center        // ícono centrado
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = contentDescription,
            tint = Color.Unspecified               // respeta el color original del ícono
        )
    }
}

// La fila con los 3 botones, igual en Login y Register
@Composable
fun SocialButtonsRow(
    modifier: Modifier = Modifier,
    onGoogleClick: () -> Unit = {},
    onFacebookClick: () -> Unit = {},
    onAppleClick: () -> Unit = {}
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp)  // Figma: 10 entre botones
    ) {
        SocialButton(
            iconRes = R.drawable.ic_google,
            contentDescription = "Google",
            onClick = onGoogleClick
        )
        SocialButton(
            iconRes = R.drawable.ic_facebook,
            contentDescription = "Facebook",
            onClick = onFacebookClick
        )
        SocialButton(
            iconRes = R.drawable.ic_apple,
            contentDescription = "Apple",
            onClick = onAppleClick
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SocialButtonsRowPreview() {
    TP3MyApplicationTheme {
        Surface {
            SocialButtonsRow(modifier = Modifier.padding(24.dp))
        }
    }
}