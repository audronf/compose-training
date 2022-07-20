package com.audronf.compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.audronf.compose.R

@Composable
fun MovieRate(stars: Int) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        LazyRow() {
            items(stars) {
                Image(painter = painterResource(id = R.drawable.ic_star), contentDescription = "")
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = stars.toString(), fontSize = 12.sp, fontWeight = FontWeight.Light)
    }

}
