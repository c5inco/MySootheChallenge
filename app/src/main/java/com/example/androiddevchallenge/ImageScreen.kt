package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun ImageScreen(
    title: String = "Sample image",
    imageId: Int = R.drawable.self_massage,
    onDismiss: () -> Unit = {}
) {
    Box(
        Modifier.fillMaxSize()
    ) {
        Image(
            painterResource(id = imageId),
            contentDescription = "Image of $title",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .height((56 * 3).dp)
                .drawBehind {
                    drawRect(
                        Brush.verticalGradient(
                            0f to Color.Black.copy(alpha = 0.6f),
                            0.3f to Color.Black.copy(alpha = 0.3f),
                            1f to Color.Black.copy(alpha = 0f),
                        )
                    )
                },
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CompositionLocalProvider(LocalContentColor provides Color.White) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    IconButton(onClick = { onDismiss() }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close action"
                        )
                    }
                    Text(
                        title,
                        style = MaterialTheme.typography.h3
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.HelpOutline,
                        contentDescription = "Help action"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ImageScreenPreview() {
    MyTheme {
        ImageScreen()
    }
}