package com.audronf.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.audronf.compose.ui.screens.Favorites
import com.audronf.compose.ui.screens.Home
import com.audronf.compose.ui.screens.Profile
import com.audronf.compose.ui.screens.Search
import com.audronf.compose.ui.viewmodel.SearchViewModel

@Composable
fun Navigation(
    navHostController: NavHostController,
    searchViewModel: SearchViewModel
) {
    NavHost(navController = navHostController, startDestination = "home") {
        composable(NavigationItem.Home.route) {
            Home()
        }
        composable(NavigationItem.Search.route) {
            Search(searchViewModel)
        }
        composable(NavigationItem.Favorites.route) {
            Favorites()
        }
        composable(NavigationItem.Profile.route) {
            Profile()
        }
    }
}
