package com.example.rickandmorty.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val title: String, val image: ImageVector) {
    data object Character: BottomNavItem("character", "Characters", Icons.Default.Person)
    data object Location: BottomNavItem("location", "Locations", Icons.Default.LocationOn)
    data object Episode: BottomNavItem("episode", "Episodes", Icons.Default.DateRange)
}