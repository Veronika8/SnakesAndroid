package com.example.snakesandroid.presentation.game.ui

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import kotlin.random.Random

class PlayingFieldUI : IElementUI {

    private val elements = mutableListOf<ElementUI>()
    private val snake = ElementUI()
    private val bgPaint = Paint().apply { color = Color.YELLOW }

    var width: Int=0
    var height: Int=0

    init {
        val random = Random(System.currentTimeMillis())
        for (i in 1..1890)
            elements.add(ElementUI().apply { state = random.nextInt(3) })
//        elements[random.nextInt(1890)] = ElementUI().apply { state = 1 }
//        elements.add(ElementUI().apply { state = 2 })
    }

    override fun render(canvas: Canvas) {
        canvas.drawRect(Rect(0, 0, width, height), bgPaint)

        var row = 0
        var col = 0
        val itemWidth = width/35
        val itemHeight = height/54

        for (element in elements) {

            element.x = col*itemWidth
            element.y = row*itemHeight

            element.width = itemWidth
            element.height = itemHeight

            element.render(canvas)

            if(++col == 35) {
                col = 0
                if (++row == 54)
                    return
            }
        }
    }
}