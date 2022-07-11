package com.audronf.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.audronf.compose.ui.screens.Favorites
import com.audronf.compose.ui.screens.Home
import com.audronf.compose.ui.screens.Profile
import com.audronf.compose.ui.screens.Search

@Composable
fun Navigation(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = "home") {
        composable(NavigationItem.Home.route) {
            Home()
        }
        composable(NavigationItem.Search.route) {
            Search()
        }
        composable(NavigationItem.Favorites.route) {
            Favorites()
        }
        composable(NavigationItem.Profile.route) {
            Profile()
        }
    }
}
