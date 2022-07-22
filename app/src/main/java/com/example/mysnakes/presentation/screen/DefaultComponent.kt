package com.example.mysnakes.presentation.screen

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AppButton(name: String,
              route: String? = null,
              navController: NavController? = null) {
    Button(onClick = {
        if (navController != null && route != null) {
            navController.navigate(route)
        }
    }) {
        Text(text = name)
    }
}

@Composable
fun AppText() {
    Text(text = "Snake game!")
}