package com.example.rickandmorty.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmorty.ui.navigation.AppBar
import com.example.rickandmorty.ui.navigation.BottomNavigationBar
import com.example.rickandmorty.ui.navigation.NavigationGraph

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold (
        topBar = { AppBar(navController) },
        bottomBar = { BottomNavigationBar(navController) }
    ){ innerPadding ->
        NavigationGraph(navController, innerPadding)
    }
}