package com.example.mysnakes.presentation.model


class Snake {
    var body: MutableList<Pair<Int, Int>> = startPositionSnake()

    fun addBodyElement(element: Pair<Int, Int>) {
        body.add(element)
    }

    fun updateDelayPosition(element: Pair<Int, Int>) {
        body =
            (listOf(element) + body.take(body.size - 1))
                    as MutableList<Pair<Int, Int>>
    }

    fun createNewSnakeElement(move: MyPair): Pair<Int, Int> {
        return body.first().let { poz ->
            Pair(
                poz.first + move.x,
                poz.second + move.y
            )
        }
    }

    private fun startPositionSnake(): MutableList<Pair<Int, Int>> {
        return mutableListOf(
            Pair(1, 30),
            Pair(2, 30),
            Pair(3, 30)  // snake head
        )
    }
}