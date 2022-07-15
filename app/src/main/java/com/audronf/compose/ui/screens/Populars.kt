package com.audronf.compose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

@Composable
fun Populars(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(PaddingValues(24.dp, 24.dp, 24.dp, 0.dp))
            .verticalScroll(rememberScrollState())
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

        }
    }
}
