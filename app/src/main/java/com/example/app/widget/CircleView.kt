package com.example.app.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.app.dp

/**
 * 类描述：
 * @author sungen
 * @date 2020/7/9 11:24 AM
 **/
private val RADIUS = 100.dp
private val PADDING = 100.dp

class CircleView(context: Context?, attrs: AttributeSet?) : View(context,attrs) {
    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val size = (PADDING + RADIUS * 2).toInt()
        val width = resolveSize(size, widthMeasureSpec)
        val height = resolveSize(size, heightMeasureSpec)
        setMeasuredDimension(width, height)
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(RADIUS + PADDING, RADIUS + PADDING, RADIUS, mPaint)
    }
}