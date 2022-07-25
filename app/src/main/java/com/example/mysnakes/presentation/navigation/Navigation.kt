package com.example.mysnakes.presentation.navigation

sealed class Screen(val route: String) {
    object Menu : Screen(route = "menu_screen")
    object Game : Screen(route = "game_screen")
    object Records : Screen(route = "high_scores_screen")
    object Settings : Screen(route = "settings_screen")
    object About : Screen(route = "about_screen")
}