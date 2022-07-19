package com.audronf.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.audronf.compose.ui.theme.ComposeTrainingTheme
import com.audronf.compose.ui.viewmodel.PopularsViewModel
import com.audronf.compose.ui.viewmodel.SearchViewModel

class MainActivity : ComponentActivity() {

    private val searchViewModel: SearchViewModel by viewModels<SearchViewModel>()
    private val popularsViewModel: PopularsViewModel by viewModels<PopularsViewModel>()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(searchViewModel, popularsViewModel)
        }
    }
}
