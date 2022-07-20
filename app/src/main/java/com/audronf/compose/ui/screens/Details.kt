package com.audronf.compose.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.audronf.compose.model.Movie
import com.audronf.compose.ui.components.MovieDetailHeader
import com.audronf.compose.ui.components.MovieRate
import com.audronf.compose.ui.theme.Typography
import com.audronf.compose.ui.viewmodel.DetailsViewModel

@Composable
fun Details(
    navHostController: NavHostController,
    viewModel: DetailsViewModel
) {
    val data by viewModel.details.observeAsState()
    LaunchedEffect(Unit) { viewModel.getPopularMovies() }
    data?.let { DetailsScreen(navHostController, it) }
}

@Composable
fun DetailsScreen(navHostController: NavHostController, movie: Movie) {
    with(movie) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Row {
                MovieDetailHeader(navHostController, image, age, duration)
            }
            Column(modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()){
                Row {
                   Text(text = genre.uppercase(), color = Color.Gray, fontSize = 12.sp)
                }
                Row {
                    Text(text = name, style = Typography.h5, fontWeight = FontWeight.Bold)
                }
                MovieRate(stars = stars)
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Text(text = synopsis, color = Color.Gray, fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.weight(1f))
                Row() {
                   Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF031939), contentColor = Color.White), modifier = Modifier.fillMaxWidth()) {
                       Text(text = "Agregar a favoritos".uppercase(), fontWeight = FontWeight.Light, modifier = Modifier.padding(0.dp, 4.dp))
                   }
                }
            }
        }
    }
}
