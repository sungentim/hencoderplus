package com.example.app.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.app.px

private val RADIUS = 100f.px

class TestView(context: Context, attributes: AttributeSet) : View(context, attributes) {
    override fun onDraw(canvas: Canvas) {
        var paint = Paint(Paint.ANTI_ALIAS_FLAG)
        canvas.drawLine(100f, 100f, 200f, 200f, paint)
    }
}