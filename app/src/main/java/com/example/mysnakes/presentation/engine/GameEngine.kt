package com.example.mysnakes.presentation.engine

import com.example.mysnakes.presentation.model.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class GameEngine(scope: CoroutineScope) {
    private val mutex = Mutex()
    private val mutableState =
        MutableStateFlow(
            startPositionSnake()
        )
    val state: Flow<State> = mutableState

    var gameState: GameState = GameState.NONE  // mutableStateOf

    private fun startPositionSnake(): State {
        return State(
            food = Food(),
            snake = Snake(),
            currentDirection = RightDirection(),
            score = 0,
            n_time = 0,
        )
    }

    fun moveUpdate(direction: Direction) {
        when (direction) {
            Direction.LEFT -> mutableState.update {
                it.copy(
                    currentDirection = it.currentDirection.left()
                )
            }
            Direction.RIGHT -> mutableState.update {
                it.copy(
                    currentDirection = it.currentDirection.right()
                )
            }
        }
    }

    init {
        scope.launch {
            while (true) {
                delay(200)
//                delay(150)
                if (gameState == GameState.START) {
                    mutableState.update {
                        val newElement = it.snake.body.first().let { _ ->
                            mutex.withLock {
                                it.snake.createNewSnakeElement(it.currentDirection.move)
                            }
                        }

                        if (newElement == it.food.position) {
                            it.food.generate()
                            it.snake.addBodyElement(newElement)
                            it.score = it.score + 10
                        }
                        it.snake.updateDelayPosition(newElement)

                        it.copy(
                            n_time = it.n_time + 1
                        )
                    }
                }
            }
        }
    }
}