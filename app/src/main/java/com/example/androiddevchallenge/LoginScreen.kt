package com.example.androiddevchallenge

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun LoginScreen() {
    var emailAddress by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Surface(
        Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Box(Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.login),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Log in".toUpperCase(),
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                )
                Spacer(Modifier.height(8.dp))
                Button(
                    onClick = { },
                    modifier = Modifier
                        .height(72.dp)
                        .fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text("Log in".toUpperCase())
                }
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
    }
}

@Preview(name = "Login screen", device = Devices.PIXEL_4)
@Preview(name = "Login screen (dark)", device = Devices.PIXEL_4, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun LoginScreenPreview() {
    MyTheme {
        LoginScreen()
    }
}