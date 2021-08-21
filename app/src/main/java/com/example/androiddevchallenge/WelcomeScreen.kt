package com.example.androiddevchallenge

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun WelcomeScreen(
    onLogin: () -> Unit = {}
) {
    Surface(
        Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Box(Modifier.fillMaxSize()) {
            //Image(
            //    painter = painterResource(id = R.drawable.welcome),
            //    contentDescription = null,
            //    contentScale = ContentScale.FillBounds,
            //    modifier = Modifier.fillMaxSize()
            //)
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Welcome logo"
                )
                Spacer(Modifier.height(32.dp))
                Button(
                    onClick = { },
                    modifier = Modifier
                        .height(72.dp)
                        .fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text("Sign up".uppercase())
                }
                Spacer(Modifier.height(8.dp))
                Button(
                    onClick = { onLogin() },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary,
                    ),
                    modifier = Modifier
                        .height(72.dp)
                        .fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text("Log in".uppercase())
                }
            }
        }
    }
}

@Preview(name = "Welcome screen", device = Devices.PIXEL_4)
@Preview(name = "Welcome screen (dark)", device = Devices.PIXEL_4, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun WelcomeScreenPreview() {
    MyTheme {
        WelcomeScreen()
    }
}