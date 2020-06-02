package com.example.app.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.example.app.dp

/**
 * 类描述：
 * @author sungen
 * @date 2020/6/1 5:15 PM
 **/
private val RADIUS = 100.dp()
private val CIRCLE_WIDTH = 20.dp()

class VerticalTextView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val circlePaint = Paint().apply {
        style = Paint.Style.STROKE
        color = Color.parseColor("#94A3AD")
        strokeWidth = CIRCLE_WIDTH
    }
    private val colorPaint = Paint().apply {
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
        color = Color.parseColor("#F04D7F")
        strokeWidth = CIRCLE_WIDTH
    }
    private val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#F04D7F")
        textSize = 20.dp()
        textAlign = Paint.Align.CENTER
    }
    private val textBounds = Rect()
    private val fontMetrics = textPaint.fontMetrics

    override fun onDraw(canvas: Canvas) {
        canvas.drawCircle(width / 2f, height / 2f, RADIUS, circlePaint)
        canvas.drawArc(width / 2f - RADIUS, height / 2f - RADIUS, width / 2f + RADIUS,
                height / 2f + RADIUS, -90f, 225f, false, colorPaint)
        textPaint.getTextBounds("adab", 0, "abab".length, textBounds)
        canvas.drawLine(0f, height / 2f, width.toFloat(), height / 2f, textPaint)
        canvas.drawText("abab", width / 2f, height / 2f - (fontMetrics.top + fontMetrics.bottom) / 2f, textPaint)

    }
}