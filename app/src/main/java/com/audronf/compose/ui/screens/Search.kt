package com.audronf.compose.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.audronf.compose.R
import com.audronf.compose.ui.components.Genre
import com.audronf.compose.ui.components.MoviePreview
import com.audronf.compose.ui.components.SearchBox
import com.audronf.compose.ui.viewmodel.SearchViewModel

@Composable
fun Search(searchViewModel: SearchViewModel) {
    val data by searchViewModel.searchScreen.observeAsState()
    searchViewModel.retrieveData()
    data?.let { SearchScreen(searchViewModel = searchViewModel) }
}

@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel
) {
    LaunchedEffect(key1 = "i") {
        searchViewModel.retrieveData()
    }
    val data = remember { searchViewModel.searchScreen.value }
    data?.let {
        Column(modifier = Modifier.padding(24.dp)) {
            Row {
                Text(
                    text = stringResource(id = R.string.search_title),
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                SearchBox()
            }
            Spacer(modifier = Modifier.height(28.dp))
            Row {
                Text(
                    text = stringResource(id = R.string.genres),
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Light
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(it.genres) {
                        Genre(color = Color(it.background.toColorInt()), it.name, it.image)
                    }
                }
            }
            Spacer(modifier = Modifier.height(28.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = stringResource(id = R.string.populars_title),
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Light,
                    )
                }
                Column {
                    Text(
                        text = stringResource(id = R.string.see_more),
                        color = Color(0xFF2E69F7),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable { /* TODO: Add listener */ }
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    items(it.popular) {
                        MoviePreview(it.name, it.image, it.genre)
                    }
                }
            }
        }
    }
}
