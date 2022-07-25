package com.example.mysnakes.presentation.model


class Snake {
    var body: List<Pair<Int, Int>> = startPositionSnake()

    fun updateDelayPosition(move: MyPair) {
        body = listOf(createNewSnakeElement(move)) + body.take(body.size - 1)
    }

    private fun createNewSnakeElement(move: MyPair): Pair<Int, Int> {
        return body.first().let { poz ->
            Pair(
                poz.first + move.x,
                poz.second + move.y
            )
        }
    }

    private fun startPositionSnake(): List<Pair<Int, Int>> {
        return listOf(
            Pair(1, 30),
            Pair(2, 30),
            Pair(3, 30)  // snake head
        )
    }
}