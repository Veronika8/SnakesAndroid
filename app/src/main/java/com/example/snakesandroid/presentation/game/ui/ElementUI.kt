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

//    val elementFood = ElementFoodUI()
//    val elementBlockSnake = ElementBlockSnakeUI()

    val paintRed = Paint().apply { color = Color.RED }
    val paintBlue = Paint().apply { color = Color.BLUE }
    val paintYellow = Paint().apply { color = Color.YELLOW }

    var x: Int = 0
    var y: Int = 0
    var width: Int = 0
    var height: Int = 0
    var state: Int = STATE_UNDEFINED

    override fun render(canvas: Canvas) {
        when(state) {
            STATE_FOOD -> ElementFoodUI().renderFood(canvas)
            STATE_SNAKE -> ElementBlockSnakeUI().renderBlockSnake(canvas)
        }
    }

//    private fun renderFood(canvas: Canvas) {
//        val x = x.toFloat()
//        val y = y.toFloat()
//        val w = width.toFloat()
//        val h = height.toFloat()
//
//        canvas.drawRect(x, y, x+w, y+h, paintRed)
//    }

//    fun createSnake(canvas: Canvas) {
//        for (z in 0..2) {
//            if (z==0) {
//                renderHeadSnake(canvas)
//            } else {
//                renderBlockSnake(canvas)
//            }
//        }
//    }
//
//     fun renderBlockSnake(canvas: Canvas) {
//        val x = x.toFloat()
//        val y = y.toFloat()
//        val w = width.toFloat()
//        val h = height.toFloat()
//
//        canvas.drawRect(x, y, x+w, y+h, paintBlue)
//        canvas.drawRect(x+w*0.8f, y+h*0.8f, x+w-w*0.8f, y+h-h*0.8f, paintYellow)
//        canvas.drawRect(x+w*0.7f, y+h*0.7f, x+w-w*0.7f, y+h-h*0.7f, paintBlue)
//    }
//
//    private fun renderHeadSnake(canvas: Canvas) {
//        val paintClr = Paint().apply { color = getRandomColor() }
//        val x = x.toFloat()
//        val y = y.toFloat()
//        val w = width.toFloat()
//        val h = height.toFloat()
//
//        canvas.drawRect(x, y, x+w, y+h, paintClr)
//        canvas.drawRect(x+w*0.8f, y+h*0.8f, x+w-w*0.8f, y+h-h*0.8f, paintYellow)
//        canvas.drawRect(x+w*0.7f, y+h*0.7f, x+w-w*0.7f, y+h-h*0.7f, paintClr)
//    }

    fun getRandomColor(): Int {
        val rnd = Random(System.currentTimeMillis())
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}