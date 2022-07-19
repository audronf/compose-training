package com.audronf.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import com.audronf.compose.ui.viewmodel.DetailsViewModel
import com.audronf.compose.ui.viewmodel.PopularsViewModel
import com.audronf.compose.ui.viewmodel.SearchViewModel

class MainActivity : ComponentActivity() {

    private val searchViewModel: SearchViewModel by viewModels<SearchViewModel>()
    private val popularsViewModel: PopularsViewModel by viewModels<PopularsViewModel>()
    private val detailsViewModel: DetailsViewModel by viewModels<DetailsViewModel>()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(searchViewModel, popularsViewModel, detailsViewModel)
        }
    }
}
