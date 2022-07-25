package com.example.mysnakes.presentation.engine

import androidx.compose.ui.unit.dp

class BoardEngine {
    companion object {
        const val Size = 32
        val BorderSize by lazy { 2.dp }
        val BoxWithConstraintsPadding by lazy { 16.dp }
    }
}