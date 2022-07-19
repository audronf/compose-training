package com.audronf.compose.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.audronf.compose.R
import com.audronf.compose.model.PopularsScreen
import com.audronf.compose.ui.components.MoviePreview
import com.audronf.compose.ui.viewmodel.PopularsViewModel

@ExperimentalFoundationApi
@Composable
fun Populars(navHostController: NavHostController, viewModel: PopularsViewModel) {
    val data by viewModel.populars.observeAsState()
    LaunchedEffect(Unit) { viewModel.getPopularMovies() }
    data?.let { PopularsScreen(navHostController = navHostController, it) }
}

@ExperimentalFoundationApi
@Composable
fun PopularsScreen(navHostController: NavHostController, data: PopularsScreen) {
    Column(
        modifier = Modifier
            .padding(PaddingValues(24.dp, 24.dp, 24.dp, 0.dp))
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.Black),
                modifier = Modifier.clickable { navHostController.navigateUp() }
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row {
            Text(
                text = stringResource(id = R.string.populars_title),
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            LazyVerticalGrid(
                cells = GridCells.Fixed(3),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(data.populars) {
                    MoviePreview(it.name, it.image, it.genre)
                }
            }
        }
    }
}
