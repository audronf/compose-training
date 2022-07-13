package com.audronf.compose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.audronf.compose.R

@Composable
fun SearchBox() {
    var text by remember { mutableStateOf("") }
    Surface() {
        TextField(
            value = text,
            onValueChange = { value -> text = value },
            leadingIcon = { Icon(Icons.Outlined.Search, "") },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_movies_placeholder)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .scale(scaleX = 1F, scaleY = 0.9F),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.DarkGray,
                disabledTextColor = Color.Gray,
                backgroundColor = Color(0xFFF1F7Fe),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            singleLine = true
        )
    }
}
