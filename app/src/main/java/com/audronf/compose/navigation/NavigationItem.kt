package com.audronf.compose.navigation

import com.audronf.compose.R

sealed class NavigationItem(
    val route: String,
    val internalRoutes: List<String> = listOf(),
    val iconId: Int,
    val title: String,
) {
    object Home :
        NavigationItem(route = Paths.HOME_PATH, iconId = R.drawable.ic_home, title = "Inicio")

    object Search : NavigationItem(
        route = Paths.SEARCH_PATH,
        internalRoutes = listOf(Paths.MAIN_SEARCH_SCREEN_PATH, Paths.POPULARS_PATH, Paths.DETAILS_PATH),
        iconId = R.drawable.ic_search,
        title = "Buscar"
    )

    object Favorites : NavigationItem(
        route = Paths.FAVORITES_PATH,
        iconId = R.drawable.ic_favorites,
        title = "Favoritos"
    )

    object Profile :
        NavigationItem(route = Paths.PROFILE_PATH, iconId = R.drawable.ic_profile, title = "Perfil")
}
