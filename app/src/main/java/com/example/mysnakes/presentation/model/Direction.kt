package com.example.mysnakes.presentation.model

abstract class BaseDirection {
    abstract val move: MyPair
    abstract fun left(): BaseDirection
    abstract fun right(): BaseDirection
}

class RightDirection : BaseDirection() {
    override val move: MyPair
        get() = MyPair(1, 0)

    override fun left(): BaseDirection {
        return UpDirection()
    }

    override fun right(): BaseDirection {
        return DownDirection()
    }
}

class UpDirection : BaseDirection() {
    override val move: MyPair
        get() = MyPair(0, -1)

    override fun left(): BaseDirection {
        return LeftDirection()
    }

    override fun right(): BaseDirection {
        return RightDirection()
    }
}

class LeftDirection : BaseDirection() {
    override val move: MyPair
        get() = MyPair(-1, 0)

    override fun left(): BaseDirection {
        return DownDirection()
    }

    override fun right(): BaseDirection {
        return UpDirection()
    }
}

class DownDirection : BaseDirection() {
    override val move: MyPair
        get() = MyPair(0, 1)

    override fun left(): BaseDirection {
        return RightDirection()
    }

    override fun right(): BaseDirection {
        return LeftDirection()
    }
}

enum class Direction {
    LEFT, RIGHT
}
