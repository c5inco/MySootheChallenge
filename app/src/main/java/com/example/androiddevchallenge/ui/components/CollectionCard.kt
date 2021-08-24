package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun CollectionCard(
    title: String,
    imageId: Int
) {
    Row(
        Modifier
            .width(192.dp)
            .clip(RoundedCornerShape(2.dp))
            .background(color = MaterialTheme.colors.surface),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(id = imageId),
            contentDescription = "Image for $title",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(56.dp)
        )
        Spacer(Modifier.width(16.dp))
        Text(
            title,
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(end = 8.dp)
        )
    }
}

@Preview
@Composable
fun CollectionCardPreview() {
    MyTheme {
        Surface {
            Column(
                Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CollectionCard(
                    title = "Nature meditations",
                    imageId = R.drawable.nature_meditations
                )
                CollectionCard(
                    title = "Stress and anxiety",
                    imageId = R.drawable.stress_and_anxiety
                )
                CollectionCard(
                    title = "Overwhelmed",
                    imageId = R.drawable.overwhelmed
                )
            }
        }
    }
}