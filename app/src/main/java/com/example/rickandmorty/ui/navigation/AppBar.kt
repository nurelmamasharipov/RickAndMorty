package com.example.rickandmorty.ui.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    TopAppBar(
        title = { Text(getTitleForRoute(currentRoute)) },
    )
}

fun getTitleForRoute(route: String?): String {
    return when (route) {
        BottomNavItem.Character.route -> "Персонажи"
        BottomNavItem.Location.route -> "Локации"
        BottomNavItem.Episode.route -> "Эпизоды"
        else -> "Rick and Morty"
    }
}
