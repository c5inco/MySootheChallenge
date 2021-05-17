/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.theme

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val DarkColorPalette = darkColors(
    primary = Color.White,
    secondary = rust300,
    background = gray900,
    surface = Color.White.copy(alpha = 0.15f),
    onPrimary = gray900,
    onSecondary = gray900,
    onBackground = taupe100,
    onSurface = Color.White.copy(alpha = 0.8f)
)

private val LightColorPalette = lightColors(
    primary = gray900,
    secondary = rust600,
    background = taupe100,
    surface = Color.White.copy(alpha = 0.85f),
    onSecondary = Color.White,
    onBackground = taupe800,
    onSurface = gray900.copy(alpha = 0.8f),
)

@Composable
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

@Preview(name = "Light colors test", showBackground = true)
@Preview(name = "Dark colors test", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ColorsThemeTest() {
    MyTheme {
        Column {
            Button(onClick = { /*TODO*/ }) {
                Text("Sign up")
            }
            Spacer(Modifier.height(32.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                )
            ) {
                Text("Log in")
            }
        }
    }
}

@Preview(name = "Typography test", showBackground = true)
@Composable
fun TypographyThemeTest() {
    MyTheme {
        Column {
            Text(
                "H1 / Kulim Park Light",
                style = MaterialTheme.typography.h1
            )
            Text("H2 / Kulim Park Regular".toUpperCase(),
                style = MaterialTheme.typography.h2
            )
            Text("H3 / Lato Bold",
                style = MaterialTheme.typography.h3
            )
            Text("Body1 / Lato Regular",
                style = MaterialTheme.typography.body1
            )
            Text("Button / Lato Bold".toUpperCase(),
                style = MaterialTheme.typography.button
            )
            Text("Caption / Kulim Park Regular",
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Preview(name = "Shapes test", showBackground = true)
@Composable
fun ShapesThemeTest() {
    MyTheme {
        Column {
            TextField(value = "This is a value", onValueChange = {})
            Card {
                Column(Modifier.padding(20.dp)) {
                    Text("This is a card")
                }
            }
            Card(Modifier.padding(20.dp)) {
                Column() {
                    Text("This is a card")
                }
            }
            Button(onClick = { /*TODO*/ }) {
                Text("Sign up")
            }
        }
    }
}
