package com.example.mysnakes.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mysnakes.presentation.activity.ui.theme.Pink40
import com.example.mysnakes.presentation.activity.ui.theme.Purple40
import com.example.mysnakes.presentation.engine.BoardEngine
import com.example.mysnakes.presentation.model.State

@Composable
fun AppButton(
    name: String,
    onClick: () -> Unit
) {
    Button(onClick = onClick) {
        Text(text = name)
    }
}

@Composable
fun AppIconButton(icon: ImageVector, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Pink40,
                shape = RoundedCornerShape(4.dp)
            ),
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun AppText(
    text: String,
    fontSize: TextUnit = 15.sp
) {
    Text(text = text, fontSize = fontSize)
}

@Composable
fun Board(state: State) {
    BoxWithConstraints(Modifier.padding(BoardEngine.BoxWithConstraintsPadding)) {
        val tileSize = maxWidth / BoardEngine.Size
        Box(
            Modifier
                .size(maxWidth)
                .border(BoardEngine.BorderSize, Purple40)
        )
        Box(
            Modifier
                .offset(
                    x = tileSize * state.food.position.x,
                    y = tileSize * state.food.position.y
                )
                .size(tileSize)
                .background(
                    Purple40, CircleShape
                )
        )
        state.snake.body.forEach {
            Box(
                modifier = Modifier
                    .offset(x = tileSize * it.first, y = tileSize * it.second)
                    .size(tileSize)
                    .background(
                        Purple40, RoundedCornerShape(4.dp)
                    )
            )
        }
    }
}
