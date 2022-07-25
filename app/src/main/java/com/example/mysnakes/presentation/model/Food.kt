package com.example.mysnakes.presentation.model

import com.example.mysnakes.presentation.engine.BoardEngine
import java.util.*


class Food {
    var position: Pair<Int, Int> = generateRandomPair()

    fun generate() {  // TODO убрать возможное попадание еды в змею
        position = generateRandomPair()
    }

    private fun generateRandomPair(): Pair<Int, Int> {
        return Pair(
            Random().nextInt(BoardEngine.Size),
            Random().nextInt(BoardEngine.Size)
        )
    }
}