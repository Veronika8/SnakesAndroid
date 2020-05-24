package com.example.snakesandroid.presentation.game.ui

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.snakesandroid.R
import kotlin.random.Random

open class ElementUI: IElementUI {

    companion object {
        const val STATE_UNDEFINED = 0
        const val STATE_FOOD = 1
        const val STATE_SNAKE = 2
    }

    val paintRed = Paint().apply { color = Color.RED }
    val paintBlue = Paint().apply { color = Color.BLUE }
    val paintYellow = Paint().apply { color = Color.YELLOW }

    var isStart: Boolean = false
    var x: Int = 0
    var y: Int = 0
    var width: Int = 0
    var height: Int = 0
    var state: Int = STATE_UNDEFINED

    override fun render(canvas: Canvas) {
//        when(state) {
//            STATE_FOOD -> ElementFoodUI().render(canvas) //renderFood(canvas) //
//            STATE_SNAKE -> ElementBlockSnakeUI().render(canvas)//renderBlockSnake(canvas)
//        }
    }

    fun getRandomColor(): Int {
        val rnd = Random(System.currentTimeMillis())
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}