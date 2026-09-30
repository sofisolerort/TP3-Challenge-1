package com.example.tp3myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp3myapplication.R
import com.example.tp3myapplication.ui.components.AuthTextField
import com.example.tp3myapplication.ui.components.DecorativeBackground
import com.example.tp3myapplication.ui.components.PrimaryButton
import com.example.tp3myapplication.ui.components.SocialButtonsRow
import com.example.tp3myapplication.ui.theme.BluePrimary
import com.example.tp3myapplication.ui.theme.TP3MyApplicationTheme
import com.example.tp3myapplication.ui.theme.TextSecondary

@Composable
fun LoginScreen(
    onSignInClick: () -> Unit,              // tocar "Sign in"
    onCreateAccountClick: () -> Unit,       // tocar "Create new account"
    modifier: Modifier = Modifier,
    onForgotPasswordClick: () -> Unit = {}  // tocar "Forgot your password?"
) {
    // Estado de los campos: guarda lo que el usuario escribe
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        DecorativeBackground()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .imePadding()                          // deja lugar al teclado
                .verticalScroll(rememberScrollState()) // si no entra, scrollea
                .padding(horizontal = 31.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            // "Login here"
            Text(
                text = stringResource(R.string.login_title),
                style = MaterialTheme.typography.headlineMedium,
                color = BluePrimary
            )

            Spacer(modifier = Modifier.height(26.dp))

            // "Welcome back you've been missed!"
            Text(
                text = stringResource(R.string.login_subtitle),
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(74.dp))

            AuthTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = stringResource(R.string.common_email),
                keyboardType = KeyboardType.Email,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(29.dp))

            AuthTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = stringResource(R.string.common_password),
                isPassword = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(30.dp))

            // "Forgot your password?" alineado a la derecha
            Text(
                text = stringResource(R.string.login_forgot_password),
                style = MaterialTheme.typography.titleSmall,
                color = BluePrimary,
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable(onClick = onForgotPasswordClick)
            )

            Spacer(modifier = Modifier.height(30.dp))

            PrimaryButton(
                text = stringResource(R.string.login_sign_in),
                onClick = onSignInClick,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(30.dp))

            // "Create new account"
            TextButton(
                onClick = onCreateAccountClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(41.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.textButtonColors(contentColor = TextSecondary)
            ) {
                Text(
                    text = stringResource(R.string.login_create_account),
                    style = MaterialTheme.typography.titleSmall
                )
            }

            Spacer(modifier = Modifier.height(62.dp))

            // "Or continue with"
            Text(
                text = stringResource(R.string.common_or_continue_with),
                style = MaterialTheme.typography.titleSmall,
                color = BluePrimary
            )

            Spacer(modifier = Modifier.height(23.dp))

            SocialButtonsRow()

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true, widthDp = 428, heightDp = 926)
@Composable
private fun LoginScreenPreview() {
    TP3MyApplicationTheme {
        LoginScreen(
            onSignInClick = {},
            onCreateAccountClick = {}
        )
    }
}