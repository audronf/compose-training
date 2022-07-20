package com.audronf.compose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RoundedText(
    text: String,
    color: Color = Color.DarkGray,
    leadingIcon: ImageVector? = null
) {
    Surface(shape = RoundedCornerShape(10.dp), color = color, contentColor = Color.White) {
        Row(modifier = Modifier.padding(4.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Column {
                leadingIcon?.let {
                    Icon(imageVector = it, contentDescription = null, tint = Color.White, modifier = Modifier.size(10.dp, 10.dp))
                }
            }
            Column {
                Text(text = text, fontSize = 10.sp)
            }
        }
    }
}
