package com.example.app.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.app.entity.px
import kotlin.math.cos
import kotlin.math.sin


val ANGELS = floatArrayOf(100f, 80f, 60f, 120f)
val MOVE_DISTANCE = 10f.px
val COLORS = listOf(Color.parseColor("#E25241"),
        Color.parseColor("#E78C3D"),
        Color.parseColor("#9034AA"),
        Color.parseColor("#EB3223"))

class PieView(context: Context, attributes: AttributeSet?) :
        AppCompatTextView(context, attributes) {
    val RADIUS = 100f.px
    private var paint = Paint()


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var startAngel = 0f
        for (index in ANGELS.indices) {
            paint.color = COLORS[index]
            if (index == 2) {
                canvas.save()
                canvas.translate(MOVE_DISTANCE * cos(Math.toRadians((ANGELS[index]) / 2f.toDouble() + startAngel)).toFloat(),
                        MOVE_DISTANCE * sin(Math.toRadians((ANGELS[index]) / 2f.toDouble() + startAngel)).toFloat())
            }
            canvas.drawArc(width / 2 - RADIUS, height / 2 - RADIUS, width / 2 + RADIUS,
                    height / 2 + RADIUS, startAngel, ANGELS[index], true, paint)
            startAngel += ANGELS[index]
            if (index == 2) {
                canvas.restore()
            }
        }

    }

}