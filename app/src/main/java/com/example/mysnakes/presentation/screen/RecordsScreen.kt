package com.example.mysnakes.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.mysnakes.presentation.activity.ui.theme.MySnakesTheme
import com.example.mysnakes.presentation.navigation.Screen

@Composable
fun RecordsScreen(navController: NavHostController) {
    MySnakesTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AppText("Records")
                AppButton(
                    name = "Back",
                    navController = navController,
                    route = Screen.Menu.route
                )
            }
        }
    }
}
