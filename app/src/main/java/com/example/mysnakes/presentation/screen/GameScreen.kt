package com.example.mysnakes.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mysnakes.presentation.activity.ui.theme.MySnakesTheme
import com.example.mysnakes.presentation.engine.GameEngine
import com.example.mysnakes.presentation.model.Direction
import com.example.mysnakes.presentation.model.GameState
import com.example.mysnakes.presentation.navigation.Screen

@Composable
fun GameScreen(navController: NavHostController, gameEngine: GameEngine) {
    val state = gameEngine.state.collectAsState(initial = null)
    gameEngine.gameState = GameState.START
    MySnakesTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Row(modifier = Modifier.padding(all = 8.dp)) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        AppButton(
                            name = "Back",
                            onClick = { navController.navigate(Screen.Menu.route) }
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        AppText(
                            "Score: ${state.value?.score}",
                            fontSize = 30.sp
                        )
                    }
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    AppText("Game")
                    state.value?.let { Board(it) }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(modifier = Modifier.padding(all = 8.dp)) {
                    // TODO можно повернуться на 180+ градусов
                    Column(modifier = Modifier.weight(1f)) {
                        AppIconButton(
                            icon = Icons.Default.KeyboardArrowLeft,
                            onClick = { gameEngine.moveUpdate(Direction.LEFT) }
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        AppIconButton(
                            icon = Icons.Default.KeyboardArrowRight,
                            onClick = { gameEngine.moveUpdate(Direction.RIGHT) }
                        )
                    }
                }
            }
        }
    }
}
