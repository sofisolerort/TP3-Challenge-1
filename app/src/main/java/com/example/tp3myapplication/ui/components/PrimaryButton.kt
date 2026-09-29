package com.example.tp3myapplication.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp3myapplication.R
import com.example.tp3myapplication.ui.theme.BluePrimary
import com.example.tp3myapplication.ui.theme.ButtonShadow
import com.example.tp3myapplication.ui.theme.TP3MyApplicationTheme

@Composable
fun PrimaryButton(
    text: String,              // lo que dice el botón
    onClick: () -> Unit,       // qué hace al tocarlo (lo decide la pantalla)
    modifier: Modifier = Modifier  // el ancho lo decide la pantalla
) {
    val shape = RoundedCornerShape(10.dp)  // Figma: bordes de 10

    Button(
        onClick = onClick,
        modifier = modifier
            .height(60.dp)                  // Figma: alto 60
            .shadow(                        // Figma: sombra azul clarita
                elevation = 10.dp,
                shape = shape,
                ambientColor = ButtonShadow,
                spotColor = ButtonShadow
            ),
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = BluePrimary,   // fondo azul
            contentColor = Color.White      // texto blanco
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleLarge  // Poppins SemiBold 20
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PrimaryButtonPreview() {
    TP3MyApplicationTheme {
        Surface {
            PrimaryButton(
                text = stringResource(R.string.login_sign_in),
                onClick = {},
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
            )
        }
    }
}