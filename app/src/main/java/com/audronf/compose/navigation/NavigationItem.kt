package com.audronf.compose.navigation

import com.audronf.compose.R

sealed class NavigationItem(val route: String, val iconId: Int, val title: String) {
    object Home: NavigationItem("home", R.drawable.ic_home, "Home")
    object Search: NavigationItem("search", R.drawable.ic_search, "Search")
    object Favorites: NavigationItem("favorites", R.drawable.ic_favorites, "Favorites")
    object Profile: NavigationItem("profile", R.drawable.ic_profile, "Profile")
}
