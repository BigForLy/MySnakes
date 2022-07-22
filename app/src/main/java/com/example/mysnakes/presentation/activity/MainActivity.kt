package com.example.mysnakes.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.example.mysnakes.presentation.screen.MenuScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mysnakes.presentation.navigation.Screen
import androidx.navigation.compose.composable
import com.example.mysnakes.presentation.screen.GameScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetupNavigation(rememberNavController())
        }
    }

    @Composable
    private fun SetupNavigation(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = Screen.Menu.route
        ) {
            composable(Screen.Menu.route) { MenuScreen(navController) }
            composable(Screen.Records.route) { GameScreen(navController) }
        }
    }
}
