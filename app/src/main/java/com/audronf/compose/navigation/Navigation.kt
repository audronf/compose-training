package com.audronf.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.audronf.compose.ui.screens.*
import com.audronf.compose.ui.viewmodel.SearchViewModel

@Composable
fun Navigation(
    navHostController: NavHostController,
    searchViewModel: SearchViewModel
) {
    NavHost(navController = navHostController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            Home()
        }
        navigation(startDestination = "mainSearch", route = NavigationItem.Search.route) {
            composable("mainSearch") {
                Search(navHostController, searchViewModel)
            }
            composable("populars") {
                Populars(navHostController)
            }
        }
        composable(NavigationItem.Favorites.route) {
            Favorites()
        }
        composable(NavigationItem.Profile.route) {
            Profile()
        }
    }
}
