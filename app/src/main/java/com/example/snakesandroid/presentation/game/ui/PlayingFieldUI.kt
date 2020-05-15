package com.example.snakesandroid.presentation.game.ui

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import kotlin.random.Random

class PlayingFieldUI : IElementUI {

    private val food = mutableListOf<ElementFoodUI>()
    private val snakes = mutableListOf<ElementBlockSnakeUI>()
    private val bgPaint = Paint().apply { color = Color.YELLOW }

    var width: Int=0
    var height: Int=0

    init {
        for (i in 1..3)
            snakes.add(ElementBlockSnakeUI())
        food.add(ElementFoodUI())
    }

    override fun render(canvas: Canvas) {
        canvas.drawRect(Rect(0, 0, width, height), bgPaint)

        val random = Random(System.currentTimeMillis())
        var row = 0
        var col = 0
        val itemWidth = width/35
        val itemHeight = height/57

        for (snake in snakes ) {

            snake.x = col*itemWidth
            snake.y = row*itemHeight

            snake.width = itemWidth
            snake.height = itemHeight

            if (row == 0 && col == 0)
                snake.renderHeadSnake(canvas)
            else snake.renderBlockSnake(canvas)

            if(++col == 35) {
                col = 0
                if (++row == 57)
                    return
            }
        }
        for (fd in food ) {
            row = random.nextInt(57)
            col = random.nextInt(35)

            fd.x = col*itemWidth
            fd.y = row*itemHeight

            fd.width = itemWidth
            fd.height = itemHeight

            fd.render(canvas)
        }
    }
}