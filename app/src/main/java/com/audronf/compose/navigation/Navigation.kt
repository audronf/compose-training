package com.audronf.compose.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.audronf.compose.ui.screens.*
import com.audronf.compose.ui.viewmodel.PopularsViewModel
import com.audronf.compose.ui.viewmodel.SearchViewModel

@ExperimentalFoundationApi
@Composable
fun Navigation(
    navHostController: NavHostController,
    searchViewModel: SearchViewModel,
    popularsViewModel: PopularsViewModel
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
                Populars(navHostController, popularsViewModel)
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
