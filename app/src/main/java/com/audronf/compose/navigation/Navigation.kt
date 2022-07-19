package com.audronf.compose.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.audronf.compose.ui.screens.*
import com.audronf.compose.ui.viewmodel.DetailsViewModel
import com.audronf.compose.ui.viewmodel.PopularsViewModel
import com.audronf.compose.ui.viewmodel.SearchViewModel

@ExperimentalFoundationApi
@Composable
fun Navigation(
    navHostController: NavHostController,
    searchViewModel: SearchViewModel,
    popularsViewModel: PopularsViewModel,
    detailsViewModel: DetailsViewModel
) {
    NavHost(navController = navHostController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            Home()
        }
        navigation(startDestination = Paths.MAIN_SEARCH_SCREEN_PATH, route = NavigationItem.Search.route) {
            composable(Paths.MAIN_SEARCH_SCREEN_PATH) {
                Search(navHostController, searchViewModel)
            }
            composable(Paths.POPULARS_PATH) {
                Populars(navHostController, popularsViewModel)
            }
            composable(Paths.DETAILS_PATH) {
                Details(navHostController, detailsViewModel)
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
