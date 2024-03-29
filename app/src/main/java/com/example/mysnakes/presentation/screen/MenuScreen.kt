package com.example.mysnakes.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mysnakes.presentation.activity.ui.theme.MySnakesTheme
import com.example.mysnakes.presentation.engine.GameEngine
import com.example.mysnakes.presentation.model.GameState
import com.example.mysnakes.presentation.navigation.Screen

@Composable
fun MenuScreen(navController: NavHostController, gameEngine: GameEngine) {
    gameEngine.gameState = GameState.PAUSE
    MySnakesTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AppText("Snake game!", fontSize = 30.sp)

                Spacer(modifier = Modifier.height(30.dp))

                AppButton(
                    "Start Game",
                    onClick = { navController.navigate(Screen.Game.route) }
                )
                AppButton(
                    name = "Records",
                    onClick = { navController.navigate(Screen.Records.route) }
                )
                AppButton(
                    "Settings",
                    onClick = { navController.navigate(Screen.Settings.route) }
                )
                AppButton(
                    "About",
                    onClick = { navController.navigate(Screen.About.route) }
                )
            }
        }
    }
}
