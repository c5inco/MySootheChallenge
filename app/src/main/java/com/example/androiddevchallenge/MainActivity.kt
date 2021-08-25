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
package com.example.androiddevchallenge

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.with
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.navArgument
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : AppCompatActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@ExperimentalAnimationApi
@Composable
fun MyApp() {
    val navController = rememberAnimatedNavController()

    Surface(color = MaterialTheme.colors.background) {
        AnimatedNavHost(navController = navController, startDestination = "welcome") {
            composable("welcome",
                exitTransition = { _, _ ->
                    SharedZAxisExitTransition()
                },
                popEnterTransition = { _, _ ->
                    SharedZAxisEnterTransition()
                }
            ) {
                WelcomeScreen {
                    navController.navigate("login")
                }
            }
            composable(
                "login",
                enterTransition = { _, _ ->
                    SharedZAxisEnterTransition()
                },
                popEnterTransition = { _, _ ->
                    SharedXAxisEnterTransition()
                },
                exitTransition = { _, _ ->
                    SharedXAxisExitTransition()
                },
                popExitTransition = { _, _ ->
                    SharedZAxisExitTransition()
                },
            ) {
                var isLoggedIn by remember { mutableStateOf(false) }
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                ) {
                    AnimatedContent(
                        modifier = Modifier.weight(1f).fillMaxSize(),
                        targetState = isLoggedIn,
                        transitionSpec = {
                            SharedXAxisEnterTransition() with SharedXAxisExitTransition()
                        }
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center
                        ) {
                            if (it) {
                                InterestsScreen()
                            } else {
                                LoginScreen()
                            }
                        }
                    }
                    Row(
                        Modifier
                            .align(Alignment.End)
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        TextButton(
                            onClick = {
                                if (isLoggedIn) {
                                    isLoggedIn = false
                                } else {
                                    navController.popBackStack()
                                }
                            },
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Text("Back".uppercase())
                        }
                        Button(
                            onClick = {
                                if (isLoggedIn) {
                                    navController.navigate("home")
                                } else {
                                    isLoggedIn = true
                                }
                            },
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Text("Next".uppercase())
                        }
                    }
                }
            }
            composable(
                "home",
                enterTransition = { _, _ ->
                    SharedYAxisEnterTransition()
                },
                popEnterTransition = { _, _ ->
                    SharedZAxisEnterTransition()
                },
                exitTransition =  { _, _ ->
                    SharedYAxisExitTransition()
                }
            ) {
                HomeScreen { title, imageId ->
                    navController.navigate("image/$title/$imageId")
                }
            }
            composable(
                "image/{title}/{imageId}",
                arguments = listOf(
                    navArgument("title") { type = NavType.StringType },
                    navArgument("imageId") { type = NavType.IntType}
                ),
                enterTransition = { _, _ ->
                    SharedZAxisEnterTransition()
                },
                exitTransition =  { _, _ ->
                    SharedZAxisExitTransition()
                }
            ) { backStackEntry ->
                ImageScreen(
                    title = backStackEntry.arguments?.getString("title")!!,
                    imageId = backStackEntry.arguments?.getInt("imageId")!!,
                    onDismiss = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}

@ExperimentalAnimationApi
@Preview("Light", widthDp = 360, heightDp = 640)
@Preview("Dark", widthDp = 360, heightDp = 640, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun AppPreview() {
    MyTheme {
        WelcomeScreen()
    }
}
