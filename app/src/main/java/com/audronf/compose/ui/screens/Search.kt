package com.audronf.compose.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.audronf.compose.R
import com.audronf.compose.ui.components.Genre

@Composable
fun Search() {
    Column(modifier = Modifier.padding(24.dp)) {
        Row {
            Text(text = stringResource(id = R.string.search_title), style = MaterialTheme.typography.h4, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
           Text(text = stringResource(id = R.string.genres), style= MaterialTheme.typography.h6, fontWeight = FontWeight.Light)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            LazyRow(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                // TODO: Remove this when integration is finished.
                items(7) {
                    Genre()
                }
            }
        }
    }
}
