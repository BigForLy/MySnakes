package com.example.mysnakes.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mysnakes.presentation.navigation.Screen
import androidx.navigation.compose.composable
import com.example.mysnakes.presentation.engine.GameEngine
import com.example.mysnakes.presentation.model.GameState
import com.example.mysnakes.presentation.screen.*

class MainActivity : ComponentActivity() {
    private var gameEngine = GameEngine(scope = lifecycleScope)
    private var gameState: GameState = GameState.NONE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetupNavigation(rememberNavController())
        }
    }

    override fun onPause() {
        super.onPause()
        gameState = gameEngine.gameState
        gameEngine.gameState = GameState.NONE
    }

    override fun onResume() {
        super.onResume()
        gameEngine.gameState = gameState
    }

    @Composable
    private fun SetupNavigation(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = Screen.Menu.route
        ) {
            composable(Screen.Menu.route) { MenuScreen(navController, gameEngine) }
            composable(Screen.Records.route) { RecordsScreen(navController) }
            composable(Screen.Settings.route) { SettingsScreen(navController) }
            composable(Screen.About.route) { AboutScreen(navController) }
            composable(Screen.Game.route) { GameScreen(navController, gameEngine) }
        }
    }
}
