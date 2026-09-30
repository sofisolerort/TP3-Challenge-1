package com.example.tp3myapplication.ui.screens

import androidx.compose.foundation.background
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
fun RegisterScreen(
    onSignUpClick: () -> Unit,          // tocar "Sign up"
    onHaveAccountClick: () -> Unit,     // tocar "Already have an account"
    modifier: Modifier = Modifier
) {
    // Estado de los campos
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }

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
                .imePadding()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 31.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            // "Create Account"
            Text(
                text = stringResource(R.string.register_title),
                style = MaterialTheme.typography.headlineMedium,
                color = BluePrimary
            )

            Spacer(modifier = Modifier.height(6.dp))

            // "Create an account so you can explore all the existing jobs"
            Text(
                text = stringResource(R.string.register_subtitle),
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(52.dp))

            AuthTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = stringResource(R.string.common_email),
                keyboardType = KeyboardType.Email,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(26.dp))

            AuthTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = stringResource(R.string.common_password),
                isPassword = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(26.dp))

            AuthTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                placeholder = stringResource(R.string.register_confirm_password),
                isPassword = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(53.dp))

            PrimaryButton(
                text = stringResource(R.string.register_sign_up),
                onClick = onSignUpClick,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(30.dp))

            // "Already have an account"
            TextButton(
                onClick = onHaveAccountClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(41.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.textButtonColors(contentColor = TextSecondary)
            ) {
                Text(
                    text = stringResource(R.string.register_have_account),
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
private fun RegisterScreenPreview() {
    TP3MyApplicationTheme {
        RegisterScreen(
            onSignUpClick = {},
            onHaveAccountClick = {}
        )
    }
}