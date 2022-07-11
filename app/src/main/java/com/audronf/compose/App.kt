package com.audronf.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.audronf.compose.navigation.Navigation
import com.audronf.compose.navigation.NavigationItem
import com.audronf.compose.ui.theme.ComposeTrainingTheme
import com.audronf.compose.ui.theme.Shapes

@Preview
@Composable
fun App() {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()
    val navigationItems = listOf(
        NavigationItem.Home,
        NavigationItem.Search,
        NavigationItem.Favorites,
        NavigationItem.Profile
    )
    ComposeTrainingTheme(darkTheme = false) {
        Scaffold(
            scaffoldState = scaffoldState,
            bottomBar = {
                BottomNavigation(
                    backgroundColor = Color.White
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentScreen = navBackStackEntry?.destination?.route
                    navigationItems.forEach {
                        BottomNavigationItem(
                            label = { Text(it.title, fontSize = 9.sp) },
                            selected = currentScreen == it.route,
                            onClick = { navController.navigate(it.route) },
                            icon = {
                                Icon(
                                    painter = painterResource(it.iconId),
                                    contentDescription = it.route
                                )
                            },
                            selectedContentColor = Color.Blue,
                            unselectedContentColor = Color.Gray
                        )
                    }
                }
            }
        ) {
            Navigation(navHostController = navController)
        }
    }
}
