package com.example.snakesandroid.presentation.game

import android.content.Context
import android.graphics.Canvas
import android.os.Handler
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.snakesandroid.presentation.game.ui.PlayingFieldUI
import java.lang.Exception

class GameView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : SurfaceView(context, attrs, defStyleAttr), SurfaceHolder.Callback {

    private val sHandler = Handler()
    private val snakeRunnable = SnakeRunnable()

    companion object {
        const val RIGHT_DIRECTION = 0
        const val LEFT_DIRECTION = 1
        const val BOTTOM_DIRECTION = 2
        const val TOP_DIRECTION = 3
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) { }
    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        sfHolder = null
        sHandler.removeCallbacks(snakeRunnable)
    }
    override fun surfaceCreated(holder: SurfaceHolder?) { sfHolder = holder }

    private var sfHolder: SurfaceHolder? = null
    set(value) {
        field = value
        value?.addCallback(this)
    }

    private val playingField = PlayingFieldUI()

    init {
        sfHolder = holder
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        postOnAnimation({render()})
//        postDelayed({render() }, 2000)
    }

    fun render() {
        val holder = sfHolder ?: return
        var canvas: Canvas? = null
        try {
            canvas = holder.lockCanvas()
            if(canvas != null)
                render(canvas)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            canvas?.let { holder.unlockCanvasAndPost(it) }
        }
    }

    private fun render(canvas: Canvas) {
        playingField.width=width
        playingField.height=height
        playingField.render(canvas)
        sHandler.postDelayed(snakeRunnable, 500L)
    }

    fun moveSnake() {
        playingField.move()
        invalidate()
    }

    //
    private inner class SnakeRunnable : Runnable {
        override fun run() {
            render()
            moveSnake()
        }
    }

    fun setDirection(direction: Int) {
        playingField.setDirection(direction)
        invalidate()
    }
}