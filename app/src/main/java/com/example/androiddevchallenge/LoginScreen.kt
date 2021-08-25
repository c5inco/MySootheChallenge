package com.example.androiddevchallenge

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun LoginScreen(
    onBack: () -> Unit = {},
    onNext: () -> Unit = {}
) {
    var emailAddress by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Log in".uppercase(),
            style = MaterialTheme.typography.h1,
            modifier = Modifier.paddingFromBaseline(bottom = 32.dp)
        )
        TextField(
            value = emailAddress,
            onValueChange = { emailAddress = it },
            placeholder = { Text("Email address") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )
        Spacer(Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Password") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )
        Spacer(Modifier.height(8.dp))
        Row(
            modifier = Modifier.paddingFromBaseline(top = 32.dp)
        ) {
            Text(
                "Don't have an account? ",
            )
            Text(
                "Sign up",
                textDecoration = TextDecoration.Underline
            )
        }
    }
}

@Preview(name = "Light", device = Devices.PIXEL_4)
@Preview(name = "Dark", device = Devices.PIXEL_4, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun LoginScreenPreview() {
    MyTheme {
        Surface(
            color = MaterialTheme.colors.background,
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                LoginScreen()
            }
        }
    }
}