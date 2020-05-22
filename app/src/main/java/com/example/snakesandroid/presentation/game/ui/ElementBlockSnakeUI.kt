package com.example.snakesandroid.presentation.game.ui

import android.graphics.Canvas
import android.graphics.Paint

class ElementBlockSnakeUI: ElementUI() {

    override fun render(canvas: Canvas) { }

    fun renderBlockSnake(canvas: Canvas, z: Int) {
        val x = x[z].toFloat()
        val y = y[z].toFloat()
        val w = width.toFloat()
        val h = height.toFloat()

        canvas.drawRect(x, y, x+w, y+h, paintBlue)
        canvas.drawRect(x+w*0.8f, y+h*0.8f, x+w-w*0.8f, y+h-h*0.8f, paintYellow)
        canvas.drawRect(x+w*0.7f, y+h*0.7f, x+w-w*0.7f, y+h-h*0.7f, paintBlue)
    }

     fun renderHeadSnake(canvas: Canvas, z: Int) {
        val paintClr = Paint().apply { color = getRandomColor() }
        val x = x[z].toFloat()
        val y = y[z].toFloat()
        val w = width.toFloat()
        val h = height.toFloat()

        canvas.drawRect(x, y, x+w, y+h, paintClr)
        canvas.drawRect(x+w*0.8f, y+h*0.8f, x+w-w*0.8f, y+h-h*0.8f, paintYellow)
        canvas.drawRect(x+w*0.7f, y+h*0.7f, x+w-w*0.7f, y+h-h*0.7f, paintClr)
    }
}