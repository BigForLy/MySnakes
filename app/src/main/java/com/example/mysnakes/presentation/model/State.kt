package com.example.mysnakes.presentation.model

data class State(
    val food: Food,
    val snake: Snake,
    val currentDirection: BaseDirection,
    var score: Int,
    val n_time: Int,
)

data class MyPair(
    val x: Int,
    val y: Int
)

enum class GameState {
    START, PAUSE/*, END*/, NONE
}
