package com.example.rickandmorty.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rickandmorty.ui.screens.CharacterScreen
import com.example.rickandmorty.ui.screens.EpisodeScreen
import com.example.rickandmorty.ui.screens.LocationScreen

@Composable
fun NavigationGraph(navController: NavHostController, innerPadding : PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Character.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(BottomNavItem.Character.route) { CharacterScreen() }
        composable(BottomNavItem.Location.route) { LocationScreen() }
        composable(BottomNavItem.Episode.route) { EpisodeScreen() }
    }
}