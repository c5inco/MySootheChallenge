package com.example.androiddevchallenge

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.SampleAlignBodyItems
import com.example.androiddevchallenge.ui.SampleAlignMindItems
import com.example.androiddevchallenge.ui.SampleCollectionItems
import com.example.androiddevchallenge.ui.components.AlignCircleItem
import com.example.androiddevchallenge.ui.components.CollectionCard
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.background
            ) {
                BottomNavigationItem(
                    selected = true,
                    onClick = { },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Spa,
                            contentDescription = "Home navigation item",
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    label = {
                        Text(
                            "Home".uppercase(),
                            style = MaterialTheme.typography.caption
                        )
                    }
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Profile navigation item",
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    label = {
                        Text(
                            "Profile".uppercase(),
                            style = MaterialTheme.typography.caption
                        )
                    }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = MaterialTheme.colors.primary,
                onClick = { },
                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play icon"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {
        Column(
            Modifier.padding(vertical = 32.dp)
        ) {
            var searchValue by remember { mutableStateOf("") }
            TextField(
                value = searchValue,
                onValueChange = { searchValue = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search text field decoration",
                        modifier = Modifier.size(18.dp)
                    )
                },
                placeholder = { Text("Search", style = MaterialTheme.typography.body1) },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface
                ),
                singleLine = true,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            )
            Text(
                "Favorite collections".uppercase(),
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                    .padding(start = 16.dp)
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
            ) {
                Row {
                    Spacer(Modifier.width(16.dp))
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            for (i in 0..2) {
                                CollectionCard(
                                    title = SampleCollectionItems[i].title,
                                    imageId = SampleCollectionItems[i].imageId
                                )
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            for (j in 3..5) {
                                CollectionCard(
                                    title = SampleCollectionItems[j].title,
                                    imageId = SampleCollectionItems[j].imageId
                                )
                            }
                        }
                    }
                    Spacer(Modifier.width(16.dp))
                }
            }

            Text(
                "Align your body".uppercase(),
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                    .padding(start = 16.dp)
            )
            LazyRow(
                Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(SampleAlignBodyItems) {
                    AlignCircleItem(title = it.title, imageId = it.imageId)
                }
            }

            Text(
                "Align your mind".uppercase(),
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                    .padding(start = 16.dp)
            )
            LazyRow(
                Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(SampleAlignMindItems) {
                    AlignCircleItem(title = it.title, imageId = it.imageId)
                }
            }
        }
    }
}

@Preview(name = "Light", widthDp = 360, heightDp = 640)
@Preview(name = "Dark", widthDp = 360, heightDp = 640, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            HomeScreen()
        }
    }
}