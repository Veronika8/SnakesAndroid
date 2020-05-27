package com.example.snakesandroid.presentation.game.ui

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import com.example.snakesandroid.presentation.game.GameView
import kotlin.random.Random

class PlayingFieldUI : IElementUI {

    private val food = mutableListOf<ElementFoodUI>()
    private val snakes = mutableListOf<ElementBlockSnakeUI>()
    private val bgPaint = Paint().apply { color = Color.YELLOW }
    val paintRed = Paint().apply { color = Color.RED }

    var width: Int = 0
    var height: Int = 0
    var row = 0
    var col = 0

    init {
        addBlock()
        food.add(ElementFoodUI())
    }

    fun addBlock() {
//        var row = 0
//        var col = 0
//        val itemWidth = width / 35
//        val itemHeight = height / 57
        if (snakes.isEmpty()) {
            for (i in 1..3) {
                snakes.add(ElementBlockSnakeUI())//.apply {
//                    x = col*itemWidth
//                    y = row * itemHeight
//                    width = itemWidth
//                    height = itemHeight
//
//                })
//                if (++col == 35) {
//                    col = 0
//                    if (++row == 57)
//                        return
//                }
                if (i == 3) {
                    snakes.last().isStart = true
                }
            }
        }
    }

        override fun render(canvas: Canvas) {
            canvas.drawRect(Rect(0, 0, width, height), bgPaint)
            renderSnake(canvas)
            renderFood(canvas)
        }

        fun renderSnake(canvas: Canvas) {

            val itemWidth = width / 35
            val itemHeight = height / 57

            for (i in 0..snakes.size) {

                snakes[i].x = col * itemWidth
                snakes[i].y = row * itemHeight

                snakes[i].width = itemWidth
                snakes[i].height = itemHeight

                if (snakes[i].isStart == true)
                    snakes[i].renderHeadSnake(canvas)
                else snakes[i].renderBlockSnake(canvas)

                if (++col == 35) {
                    col = 0
                    if (++row == 57)
                        return
                }
            }
        }

        fun renderFood(canvas: Canvas) {
            val random = Random(System.currentTimeMillis())
            val itemWidth = width / 35
            val itemHeight = height / 57

            for (fd in food) {
                var row = random.nextInt(57)
                var col = random.nextInt(35)

                fd.x = col * itemWidth
                fd.y = row * itemHeight

                fd.width = itemWidth
                fd.height = itemHeight

                fd.render(canvas)
            }
        }

        fun move() {
            val itemWidth = width / 35
            val itemHeight = height / 57

//            for (snake in snakes) {
//                snake.x = snake.x + itemWidth
//                snake.y = snake.y + itemHeight
//                snake.width = itemWidth
//                snake.height = itemHeight
////                if (snake.x > width)
////                    snake.x = 0
//            }
            for (i in 0..snakes.size) {
                when(snakes[i].direction) {
                    GameView.RIGHT_DIRECTION -> {
                        snakes[i].x = snakes[i].x + itemWidth
                    }
                    GameView.LEFT_DIRECTION -> {
                        snakes[i].x = snakes[i].x -itemWidth
                    }
                    GameView.TOP_DIRECTION -> {
                        snakes[i].y = snakes[i].y - itemHeight
                    }
                    GameView.BOTTOM_DIRECTION -> {
                        snakes[i].y = snakes[i].y + itemHeight
                    }
                }
            }
        }
    fun setDirection(direction: Int) {
        when(direction) {
            GameView.RIGHT_DIRECTION -> {
                snakes[2].direction = direction
            }
            GameView.LEFT_DIRECTION -> {
                snakes[2].direction = direction
            }
            GameView.TOP_DIRECTION -> {
                snakes[2].direction = direction
            }
            GameView.BOTTOM_DIRECTION -> {
                snakes[2].direction = direction
            }
        }
    }
}
