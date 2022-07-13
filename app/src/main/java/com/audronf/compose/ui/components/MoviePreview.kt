package com.audronf.compose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun MoviePreview(
    name: String,
    image: String,
    genre: String
) {
    Card(elevation = 0.dp, modifier = Modifier.width(100.dp))  {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row {
                AsyncImage(model = image, contentDescription = null)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = name, style = MaterialTheme.typography.caption, maxLines = 2, textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = genre, style = MaterialTheme.typography.overline, color = Color.Gray, maxLines = 2, textAlign = TextAlign.Center)
            }
        }
    }
}
