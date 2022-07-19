package com.audronf.compose.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.audronf.compose.ui.viewmodel.DetailsViewModel

@Composable
fun Details(
    navHostController: NavHostController,
    viewModel: DetailsViewModel
) {
    val data by viewModel.details.observeAsState()
    LaunchedEffect(Unit) { viewModel.getPopularMovies() }
}
