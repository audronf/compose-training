package com.audronf.compose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun Genre(
    color: Color,
    name: String,
    image: String
) {
    Card(
        modifier = Modifier
            .height(112.dp)
            .width(150.dp),
        backgroundColor = color
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            Text(text = name, fontSize = 12.sp, color = Color.White, modifier = Modifier.padding(16.dp))
        }
        Column(horizontalAlignment = Alignment.End) {
            AsyncImage(model = image, contentDescription = null, modifier = Modifier.rotate(15f))
        }
    }
}
