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
import com.example.mysnakes.presentation.navigation.Screen

@Composable
fun GameScreen(navController: NavHostController, gameEngine: GameEngine) {
    val state = gameEngine.state.collectAsState(initial = null)
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
                            navController = navController,
                            route = Screen.Menu.route
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        AppText(
                            "Score: ${GameEngine.Score}",
                            fontSize = 30.sp
                        )  /* TODO: ДИНАМИЧЕСКИЙ ПОДСЧЕТ РЕЗУЛЬТАТА */
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

                Row {
                    // TODO можно повернуться на 180 градусов
                    AppIconButton(
                        icon = Icons.Default.KeyboardArrowLeft,
                        onClick = { gameEngine.moveUpdate(Direction.LEFT) }
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    AppIconButton(
                        icon = Icons.Default.KeyboardArrowRight,
                        onClick = { gameEngine.moveUpdate(Direction.RIGHT) }
                    )
                }
            }
        }
    }
}
