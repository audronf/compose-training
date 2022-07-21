package com.audronf.compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.audronf.compose.R

@Composable
fun MovieDetailHeader(
    navHostController: NavHostController,
    imageUrl: String,
    age: String,
    duration: String
) {
    Box(modifier = Modifier.clip(RoundedCornerShape(0.dp, 0.dp, 24.dp, 24.dp))) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            alignment = Alignment.TopStart
        )
        Row(modifier = Modifier
            .align(Alignment.TopStart)
            .fillMaxWidth()
            .padding(24.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .clickable { navHostController.navigateUp() }
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                RoundedText(age.uppercase())
            }
            Column {
                RoundedText(duration.uppercase(), leadingIcon = Icons.Filled.PlayArrow)
            }
        }

    }
}
