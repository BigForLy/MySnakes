package com.example.mysnakes.presentation.model

data class State(
    val food: Food,
    val snake: Snake,
    val currentDirection: BaseDirection,
    val n_time: Int
)

data class MyPair(
    val x: Int,
    val y: Int
)
