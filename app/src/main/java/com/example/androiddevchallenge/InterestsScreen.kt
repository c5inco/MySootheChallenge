package com.example.androiddevchallenge

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun InterestsScreen(
    onBack: () -> Unit = {},
    onNext: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Streamline your interests",
            style = MaterialTheme.typography.h3
        )
        Spacer(Modifier.height(16.dp))
        Text(
            "Relax, don't do it. When you wanna go do it. Relax, don't do it. When you wanna go do it",
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(32.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            for (i in 0..4) {
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text("Arts & Crafts")
                        Text(
                            "Bundled",
                            style = MaterialTheme.typography.caption
                        )
                    }
                    Switch(
                        checked = false,
                        onCheckedChange = {}
                    )
                }
            }
        }
    }
}

@Preview(name = "Light")
@Preview(name = "Dark", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun InterestsPreview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            Column(
                Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                InterestsScreen()
            }
        }
    }
}