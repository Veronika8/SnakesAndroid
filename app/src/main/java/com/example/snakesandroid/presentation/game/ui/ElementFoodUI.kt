package com.example.snakesandroid.presentation.game.ui

import android.graphics.Canvas

class ElementFoodUI: ElementUI() {

    override fun render(canvas: Canvas) {
       // var z =0 //!!!!!!!!!!!!!!!!!!!
        renderFood(canvas)
    }

     private fun renderFood(canvas: Canvas) {
        val x = x.toFloat()
        val y = y.toFloat()
        val w = width.toFloat()
        val h = height.toFloat()

        canvas.drawRect(x, y, x+w, y+h, paintRed)
    }
}