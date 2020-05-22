package com.example.snakesandroid.presentation.game.ui

import android.graphics.Canvas

class ElementFoodUI: ElementUI() {

    override fun render(canvas: Canvas) {
        var z =0 //!!!!!!!!!!!!!!!!!!!
        renderFood(canvas, z)
    }

     fun renderFood(canvas: Canvas, z: Int) {
        val x = x[z].toFloat()
        val y = y[z].toFloat()
        val w = width.toFloat()
        val h = height.toFloat()

        canvas.drawRect(x, y, x+w, y+h, paintRed)
    }
}