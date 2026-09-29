package com.example.tp3myapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp3myapplication.R
import com.example.tp3myapplication.ui.theme.BluePrimary
import com.example.tp3myapplication.ui.theme.InputBackground
import com.example.tp3myapplication.ui.theme.PlaceholderGray
import com.example.tp3myapplication.ui.theme.TP3MyApplicationTheme

@Composable
fun AuthTextField(
    value: String,                          // lo que está escrito
    onValueChange: (String) -> Unit,        // qué hacer cuando el usuario escribe
    placeholder: String,                    // texto gris cuando está vacío
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,            // true = muestra puntitos
    keyboardType: KeyboardType = KeyboardType.Text  // qué teclado abre
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.height(64.dp),                   // Figma: alto 64
        placeholder = {
            Text(
                text = placeholder,
                style = MaterialTheme.typography.bodyLarge,  // Poppins Medium 16
                color = PlaceholderGray
            )
        },
        textStyle = MaterialTheme.typography.bodyLarge,
        singleLine = true,                                   // no hace salto de línea
        shape = RoundedCornerShape(10.dp),                   // Figma: bordes de 10
        visualTransformation = if (isPassword) PasswordVisualTransformation()
        else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = if (isPassword) KeyboardType.Password else keyboardType
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = InputBackground,     // fondo celeste siempre
            unfocusedContainerColor = InputBackground,
            focusedBorderColor = BluePrimary,            // borde azul al tocarlo
            unfocusedBorderColor = Color.Transparent,    // sin borde si no está activo
            cursorColor = BluePrimary,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun AuthTextFieldPreview() {
    TP3MyApplicationTheme {
        Surface {
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(26.dp)
            ) {
                AuthTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = stringResource(R.string.common_email),
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier.fillMaxWidth()
                )
                AuthTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = stringResource(R.string.common_password),
                    isPassword = true,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}